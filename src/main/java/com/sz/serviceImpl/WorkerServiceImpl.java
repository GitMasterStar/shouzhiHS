package com.sz.serviceImpl;

import com.sz.common.vo.PageObject;
import com.sz.dao.WorkerMapper;
import com.sz.exception.ServiceException;
import com.sz.pojo.Worker;
import com.sz.service.WorkerService;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public Worker doFindWorkerById(Integer id) {
        //1.判断参数合法性
        if (id==null||id<=0)
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
    public int parseAndSava(HttpServletRequest request, HttpServletResponse response, MultipartFile file) {

        System.out.println("file:"+file);
        /*System.out.println("fileData:"+fileData);*/
        if (file.isEmpty()){
            try {
                throw new Exception("文件不存在！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return 0;
    }


}
