package com.sz.serviceImpl;

import com.sz.common.util.ExcelUtil;
import com.sz.common.vo.PageObject;
import com.sz.dao.WorkerMapper;
import com.sz.exception.ServiceException;
import com.sz.pojo.Worker;
import com.sz.service.WorkerService;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService{

    @Autowired
    private WorkerMapper workerMapper;

    @Override
    public PageObject<Worker> findPageObjects(String workername, Integer pageCurrent) {
        //1.参数合法性验证
        if (pageCurrent==null||pageCurrent<=0)
            throw new ServiceException("参数不合法");
        //2.依据条件获取总记录数
        int rowCount= workerMapper.getRowCount(workername);
        /*if (rowCount==0)
            throw new ServiceException("记录不存在");*/
        //3.计算startIndex的值
        int pageSize = 15;
        int startIndex = (pageCurrent-1)*pageSize;
        //4.依据条件获取当前页数
        List<Worker> workerList = workerMapper.findPageObjects(workername,startIndex,pageSize);
        //5.封装数据
        PageObject<Worker> pageObject = new PageObject<>();
        pageObject.setPageCurrent(pageCurrent);
        pageObject.setRowCount(rowCount);
        pageObject.setPageSize(pageSize);
        pageObject.setRecords(workerList);
        return pageObject;
    }

    @Override
    public Worker doFindWorkerById(String id) {
        //1.判断参数合法性
        if (id==null)
            throw new IllegalArgumentException("userId值参数不正确");
        //2.执行查询用户信息
        Worker worker = workerMapper.selectByPrimaryKey(id);
        return worker;
    }

    @Override
    public int doAddObject(Worker entity) {
        if(entity==null)
            throw new IllegalArgumentException("员工信息不能为空");
        if(StringUtils.isEmpty(entity.getWorkername()))
            throw new IllegalArgumentException("员工姓名不能为空");
         int rows=workerMapper.insertSelective(entity);
        return rows;
    }

    @Override
    public int doUpdateObject(Worker entity) {
        if(entity==null)
            throw new IllegalArgumentException("修改内容不能为空");
        if(StringUtils.isEmpty(entity.getWorkername()))
            throw new IllegalArgumentException("员工姓名不能为空");
        int row=workerMapper.updateByPrimaryKeySelective(entity);
        return row;
    }
    @Override
    public int doDeleteObjects(Integer... ids){
        if (ids==null)
            throw new IllegalArgumentException("请选择一名员工");
        int rows =workerMapper.deleteObjects(ids);
        return rows;
    }

    @Override
    public int doFindByWorker(Worker entity) {
        if(entity==null)
            throw new IllegalArgumentException("修改内容不能为空");
        int rows =workerMapper.doFindByWorker(entity);
        return rows;
    }

    @Override
    public String uploadParse(HttpServletRequest request, HttpServletResponse response, MultipartFile file) throws Exception {

        //1.判断file是否存在
        if (file.isEmpty()){
            try {
                throw new Exception("文件不存在！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //2.读取相应格式的Excel文件
        //2.1获取文件名
        String fileName = file.getOriginalFilename();
        //2.2创建worker集合
        List<Worker> list = new ArrayList<Worker>();
        //2.3确定时间格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //2.4创建创建Excel工作蒲，读取上传Excel文件信息
        Workbook wb = null;//创建Excel
        Sheet sheet = null;//页数
        Row row = null;//行数
        try {
            InputStream inputStream = file.getInputStream();
            String fileType = fileName.substring(fileName.lastIndexOf("."));
            if (".xls".equals(fileType)) {
                wb = new HSSFWorkbook(inputStream);
            }else if (".xlsx".equals(fileType)) {
                wb = new XSSFWorkbook(inputStream);
            }
            sheet = wb.getSheetAt(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            wb.close();
        }
        //3.遍历当前sheet中的行，获取员工信息
        for (int j = sheet.getFirstRowNum()+2; j <= sheet.getLastRowNum(); j++) {
            //3.1创建封装对象
            Worker worker = new Worker();
            //3.2获取当前行
            row = sheet.getRow(j);
            //3.3判断是否为空
            if(row==null||row.getFirstCellNum()==j){continue;}
            //3.4获取员工对应信息
            //获取ID
            String ID = ExcelUtil.getCellValueForString(row.getCell(0));
            worker.setId(ID);
            worker.setWorkeridcard(ID);
            System.out.println("ID:"+ID);
            System.out.println("身份证号:"+ID);
            //获取姓名
            String name = ExcelUtil.getCellValueForString(row.getCell(1));
            worker.setWorkername(name);
            System.out.println("姓名/name:"+name);
            //获取性别
            String sex = ExcelUtil.getCellValueForString(row.getCell(2));
            worker.setWorkersex(sex.equals("男")?"1":"0");
            System.out.println("性别/sex:"+sex);
            //获取户口性质
            String house = ExcelUtil.getCellValueForString(row.getCell(3));
            worker.setWorknative(house);
            System.out.println("户口性质/house:"+house);
            //获取部门
            String dept = ExcelUtil.getCellValueForString(row.getCell(4));
            worker.setWorkerdept(dept);
            System.out.println("部门/dept:"+dept);
            //获取员工类别
            String level = ExcelUtil.getCellValueForString(row.getCell(5));
            worker.setWorkerlevel(level);
            System.out.println("员工类别/level:"+level);
            //获取所属上级
            String leader = ExcelUtil.getCellValueForString(row.getCell(6));
            worker.setWorkerleader(leader);
            System.out.println("所属上级/leader:"+leader);
            //获取入职日期
            if (HSSFDateUtil.isCellDateFormatted(row.getCell(7))) {
                Date createDate = HSSFDateUtil.getJavaDate(row.getCell(7).getNumericCellValue());
                if (createDate != null) {
                    worker.setCreatedate(sdf.parse(sdf.format(createDate)));
                    System.out.println("入职日期/createDate:" + sdf.format(createDate));
                }
            }
            //获取签约客户
            String customer = ExcelUtil.getCellValueForString(row.getCell(8));
            worker.setWorkercustomer(customer);
            System.out.println("签约客户/customer:"+customer);
            //获取单价方式
            String PriceType = ExcelUtil.getCellValueForString(row.getCell(9));
            worker.setPricetype(PriceType);
            System.out.println("单价方式/PriceType:"+PriceType);
            //获取单价
            String Price = ExcelUtil.getCellValueForString(row.getCell(10));
            worker.setPrice(Double.parseDouble(Price));
            System.out.println("单价/Price:"+Price);
            //获取毛利值
            String grossProfit = ExcelUtil.getCellValueForString(row.getCell(11));
            worker.setStandby(grossProfit);
            System.out.println("毛利值/grossProfit:"+grossProfit);
            //获取毛利率
            String grossProfitRate = ExcelUtil.getCellValueForString(row.getCell(12));
            worker.setGrossprofitrate(grossProfitRate);
            System.out.println("毛利率/grossProfitRate:"+grossProfitRate);
            //获取流转税
            String turnOver = ExcelUtil.getCellValueForString(row.getCell(13));
            worker.setRemark(turnOver);
            System.out.println("流转税/turnOver:"+turnOver);
            //获取标准
            String normalSalary = ExcelUtil.getCellValueForString(row.getCell(14));
            worker.setNormalsalary(Double.parseDouble(normalSalary));
            System.out.println("标准/normalSalary:"+normalSalary);
            //获取基本工资
            String baseSalary = ExcelUtil.getCellValueForString(row.getCell(15));
            worker.setBasesalary(Double.parseDouble(baseSalary));
            System.out.println("基本工资/baseSalary:"+baseSalary);
            //获取绩效工资
            String performanceSalary = ExcelUtil.getCellValueForString(row.getCell(16));
            worker.setPerformancesalary(Double.parseDouble(performanceSalary));
            System.out.println("绩效工资/performanceSalary:"+performanceSalary);
            //获取试用折扣率
            String salaryRatio = ExcelUtil.getCellValueForString(row.getCell(17));
            worker.setSalaryratio(salaryRatio);
            System.out.println("试用折扣率/salaryRatio:"+salaryRatio);
            //获取六金城市
            String sixGoldCity = ExcelUtil.getCellValueForString(row.getCell(18));
            worker.setSixgoldcity(sixGoldCity);
            System.out.println("六金城市/sixGoldCity:"+sixGoldCity);
            //获取六金基数
            String sixGoldBase = ExcelUtil.getCellValueForString(row.getCell(19));
            worker.setSixgoldbase(Double.parseDouble(sixGoldBase));
            System.out.println("六金基数/sixGoldBase:"+sixGoldBase);
            //获取发薪地1
            String payCity1 = ExcelUtil.getCellValueForString(row.getCell(20));
            worker.setPaycity1(payCity1);
            System.out.println("发薪地1/payCity1:"+payCity1);
            //获取发薪金额1
            String paySalary1 = ExcelUtil.getCellValueForString(row.getCell(21));
            worker.setPaysalary1(Double.parseDouble(paySalary1));
            System.out.println("发薪金额1/paySalary1:"+paySalary1);
            //获取发薪地2
            String payCity2 = ExcelUtil.getCellValueForString(row.getCell(22));
            worker.setPaycity2(payCity2);
            System.out.println("发薪地2/payCity2:"+payCity2);
            //获取发薪金额2
            String paySalary2 = ExcelUtil.getCellValueForString(row.getCell(23));
            worker.setPaysalary2(Double.parseDouble(paySalary2));
            System.out.println("发薪金额2/paySalary2:"+paySalary2);
            //获取招行卡号
            String cmb = ExcelUtil.getCellValueForString(row.getCell(24));
            if (cmb!=null&&cmb.length()!=0) {
                worker.setCmbcaccount(cmb != null ? cmb : "");
                System.out.println("招行卡号/cmb:" + cmb);
            }
            //获取工行卡号
            String icb = ExcelUtil.getCellValueForString(row.getCell(25));
            if (icb!=null&&icb.length()!=0) {
                worker.setIcbcaccount(icb != null ? icb : "");
                System.out.println("工行卡号/icb:" + icb);
            }
            //获取设备
            String equipment = ExcelUtil.getCellValueForString(row.getCell(26));
            worker.setEquipment(equipment);
            System.out.println("设备/equipment:"+equipment);
            //获取设备补贴
            String equipmentSubsidy = ExcelUtil.getCellValueForString(row.getCell(27));
            if (equipmentSubsidy!=null&&equipmentSubsidy.length()!=0) {
                worker.setEquipmentsubsidy(Double.parseDouble(equipmentSubsidy));
                System.out.println("设备补贴/equipmentSubsidy:" + equipmentSubsidy);
            }
            //获取联系方式
            String phone = ExcelUtil.getCellValueForString(row.getCell(28));
            worker.setWorkerphone(phone);
            System.out.println("联系方式/phone:"+phone);
            //获取离职日期
            if (HSSFDateUtil.isCellDateFormatted(row.getCell(29))) {
                Date diMissionDate =  HSSFDateUtil.getJavaDate(row.getCell(29).getNumericCellValue());
                worker.setDimissiondate(sdf.parse(sdf.format(diMissionDate)));
                System.out.println("离职日期/diMissionDate:" + sdf.format(diMissionDate));
            }
            //获取子女教育
            String childEducation = ExcelUtil.getCellValueForString(row.getCell(30));
            if (childEducation!=null&&childEducation.length()!=0) {
                worker.setChildeducation(Double.parseDouble(childEducation));
                System.out.println("子女教育/childEducation:" + childEducation);
            }
            //获取继续教育
            String againEducation = ExcelUtil.getCellValueForString(row.getCell(31));
            if (againEducation!=null&&againEducation.length()!=0) {
                worker.setAgaineducation(Double.parseDouble(againEducation));
                System.out.println("继续教育/againEducation:" + againEducation);
            }
            //获取大病医疗
            String seriousIllness = ExcelUtil.getCellValueForString(row.getCell(32));
            if (seriousIllness!=null&&seriousIllness.length()!=0) {
                worker.setSeriousillness(Double.parseDouble(seriousIllness));
                System.out.println("大病医疗/seriousIllness:" + seriousIllness);
            }
            //获取住房贷款
            String houseLoans = ExcelUtil.getCellValueForString(row.getCell(33));
            if (houseLoans!=null&&houseLoans.length()!=0) {
                worker.setHouseloans(Double.parseDouble(houseLoans));
                System.out.println("住房贷款/houseLoans:" + houseLoans);
            }
            //获取租房租金
            String rentingHouse = ExcelUtil.getCellValueForString(row.getCell(34));
            if (rentingHouse!=null&&rentingHouse.length()!=0) {
                worker.setRentinghouse(Double.parseDouble(rentingHouse));
                System.out.println("租房租金/rentingHouse:" + rentingHouse);
            }
            //获取赡养老人
            String supportOld = ExcelUtil.getCellValueForString(row.getCell(35));
            if (supportOld!=null&&supportOld.length()!=0) {
                worker.setSupportold(Double.parseDouble(supportOld));
                System.out.println("赡养老人/supportOld:" + supportOld);
            }
            //获取邮箱
            String email = ExcelUtil.getCellValueForString(row.getCell(37));
            worker.setWorkeremail(email);
            System.out.println("邮箱/email:"+email);
            //设置员工默认状态
            worker.setDeclarationstatus("0");
            worker.setSocialsecuritystatus("0");
            worker.setWorkerstatus(0);
            //3.5保存员工信息到list集合
            list.add(worker);
        }
        //4.删除List集合中数据库里已有的员工信息
        String name ="",wname="";
        Iterator<Worker> workerIterator = list.iterator();
        while (workerIterator.hasNext()) {
            Worker next = workerIterator.next();
            Worker r = workerMapper.selectByPrimaryKey(next.getId());
            if (r!=null){
                name += name==""?next.getWorkername():","+next.getWorkername();
                workerIterator.remove();
            }else {
                wname += wname==""?next.getWorkername():","+next.getWorkername();
            }
        }
        System.out.println("员工"+name+"已录入数据库");
        //5.判断文件是否重复
        if (list.size()==0){
            //5.1符合条件，返回结果
            return fileName+"文件内容重复上传,无效";
        }
        //6.执行批量添加员工信息功能
        /*int rows = workerMapper.insertALL(list);
        if (rows==0)
            throw new ServiceException("导入失败");*/
        //7.返回结果
        return "上传文件成功，"+wname+"员工已导入";
    }


}
