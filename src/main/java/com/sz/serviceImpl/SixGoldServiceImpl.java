package com.sz.serviceImpl;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.pagehelper.parser.impl.HsqldbParser;
import com.sz.common.util.ExcelUtil;
import com.sz.common.vo.PageObject;
import com.sz.dao.SixGoldDetailMapper;
import com.sz.dao.WorkerMapper;
import com.sz.exception.ServiceException;
import com.sz.pojo.SixGoldDetail;
import com.sz.service.SixGoldService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class SixGoldServiceImpl implements SixGoldService {

    @Autowired
    private WorkerMapper workerMapper;
    @Autowired
    private SixGoldDetailMapper sixGoldDetailMapper;

    @Override
    public String upLoadFile(MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            throw new Exception("文件不存在");
        }
        //获取文件名
        String fileName = file.getOriginalFilename();
        //创建表集合
        ArrayList<SixGoldDetail> list = new ArrayList<>();
        //创建excel
        Workbook wb = null;
        //创建excel页数
        Sheet s1 = null;
        //创建行数
        Row row = null;
        //规定时间格式
        SimpleDateFormat sDF = new SimpleDateFormat("yyyy-MM");
        //获取sheet内容
        /* String fileType = fileName.substring(fileName.lastIndexOf("."));*/
        InputStream inputStream = file.getInputStream();
        if (fileName.endsWith("xls")) {
            wb = new HSSFWorkbook(inputStream);
        } else if (fileName.endsWith("xlsx")) {
            wb = new XSSFWorkbook(inputStream);
        }
        s1 = wb.getSheetAt(0);

        for (int i = s1.getFirstRowNum() + 3; i <= s1.getLastRowNum(); i++) {
            SixGoldDetail sixGole = new SixGoldDetail();
            row = s1.getRow(i);
            Integer time = Integer.valueOf(ExcelUtil.getCellValueForString(row.getCell(1)));
            sixGole.setPaymonth(time);
            String IdCard = ExcelUtil.getCellValueForString(row.getCell(2));
            sixGole.setWorkeridcard(IdCard);
            String name=ExcelUtil.getCellValueForString(row.getCell(3));
            sixGole.setWorkername(name);

            Double endowmententerprise = Double.valueOf(ExcelUtil.getCellValueForString(row.getCell(4)));
            sixGole.setEndowmententerprise(endowmententerprise);

            Double endowmentpersonage = Double.valueOf(ExcelUtil.getCellValueForString(row.getCell(5)));
            sixGole.setEndowmentpersonage(endowmentpersonage);

            Double medicalenterprise = Double.valueOf(ExcelUtil.getCellValueForString(row.getCell(6)));
            sixGole.setMedicalenterprise(medicalenterprise);

            Double medicalpersonage = Double.valueOf(ExcelUtil.getCellValueForString(row.getCell(7)));
            sixGole.setMedicalpersonage(medicalpersonage);

            Double unemploymententerprise = Double.valueOf(ExcelUtil.getCellValueForString(row.getCell(8)));
            sixGole.setUnemploymententerprise(unemploymententerprise);

            Double unemploymentpersonage = Double.valueOf(ExcelUtil.getCellValueForString(row.getCell(9)));
            sixGole.setUnemploymentpersonage(unemploymentpersonage);

            Double inductrialinjuryenterprise = Double.valueOf(ExcelUtil.getCellValueForString(row.getCell(10)));
            sixGole.setInductrialinjuryenterprise(inductrialinjuryenterprise);

            Double maternityenterprise = Double.valueOf(ExcelUtil.getCellValueForString(row.getCell(11)));
            sixGole.setMaternityenterprise(maternityenterprise);

            Double housingfundenterprise = Double.valueOf(ExcelUtil.getCellValueForString(row.getCell(12)));
            sixGole.setHousingfundenterprise(housingfundenterprise);

            Double housingfundpersonage = Double.valueOf(ExcelUtil.getCellValueForString(row.getCell(13)));
            sixGole.setHousingfundpersonage(housingfundpersonage);
            Double collectenterprise = Double.valueOf(ExcelUtil.getCellValueForString(row.getCell(14)));
            sixGole.setCollectenterprise(collectenterprise);
            Double collectpersonage = Double.valueOf(ExcelUtil.getCellValueForString(row.getCell(15 )));
            sixGole.setCollectpersonage(collectpersonage);
            Date date = new Date();
            sixGole.setMonth(sDF.parse(sDF.format(date)));
            list.add(sixGole);
        }


        //查看List中员工是否有重复信息
        ArrayList<String> IdCard = new ArrayList<>();
        String workeridcard=null;
        for(SixGoldDetail value : list){
            workeridcard = value.getWorkeridcard();
            System.out.println(workeridcard);
            IdCard.add(workeridcard);
        }
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<list.size();i++){
            String sfz = IdCard.get(i);
            if(set.contains(sfz)){
                throw new ServiceException("本月导入信息有重复");
            }else{
                set.add(sfz);
            }
        }

        sixGoldDetailMapper.insertAll(list);
        return fileName+"文件导入成功";
    }

    @Override
    public PageObject<SixGoldDetail> doFindPageObject(String workername, Integer pageCurrent,String month) throws Exception {
        //1.参数合法性验证
        if (pageCurrent==null||pageCurrent<=0)
            throw new ServiceException("参数不合法");
        //2.依据条件获取总记录数
        String[] split = month.split("-");
        String year = split[0];
        String months = split[1];
        int rowCount= sixGoldDetailMapper.getRowCount(workername,months,year);
        if (rowCount==0)
            throw new ServiceException("记录不存在");
        //3.计算startIndex的值
        int pageSize = 15;
        int startIndex = (pageCurrent-1)*pageSize;
        //4.依据条件获取当前页数
        List<SixGoldDetail> sixGoldList =sixGoldDetailMapper.findPageObjects(workername,startIndex,pageSize,months,year);
        //5.封装数据
        PageObject<SixGoldDetail> pageObject = new PageObject<>();
        pageObject.setPageCurrent(pageCurrent);
        pageObject.setRowCount(rowCount);
        pageObject.setPageSize(pageSize);
        pageObject.setRecords(sixGoldList);
        return pageObject;
    }
}