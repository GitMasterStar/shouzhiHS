package com.sz.serviceImpl;

import com.sz.common.vo.PageObject;
import com.sz.dao.WorkDayMapper;
import com.sz.exception.ServiceException;
import com.sz.pojo.WorkDay;
import com.sz.service.WorkDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.rmi.server.ServerCloneException;
import java.util.List;

@Service
public class WorkDayServiceImpl implements WorkDayService {

    @Autowired
    private WorkDayMapper workDayMapper;

    @Override
    public PageObject<WorkDay> findPageObjects(Integer pageCurrent) {
        //1.参数合法性校验
        //1.1验证pageCurrent的合法性
        if (pageCurrent==null||pageCurrent<1)
            throw new IllegalArgumentException("当前页码不正确");
        //2.基于条件查询总记录数
        //2.1）执行查询
        int rowCount = workDayMapper.getRowCount();
        //2.2)验证查询结果，假如rowCount等于0弹出错误提示
        if (rowCount==0)
            throw new ServiceException("没有信息，请录入新信息");
        //3.基于条件查询当前页记录（pageSize定义为10）
        //3.1)定义pageSize
        int pageSize=10;
        //3.2)计算startIndex
        int startIndex=(pageCurrent-1)*pageSize;
        //3.3)执行当前数据的查询操作
        List<WorkDay> workDayList = workDayMapper.findPageObjects(startIndex, pageSize);
        //4.对分页信息以及当前页记录进行封装
        //4.1)构建PageObject对象
        PageObject<WorkDay> pageObject = new PageObject<>();
        //4.2)封装数据
        pageObject.setRowCount(rowCount);
        pageObject.setPageCurrent(pageCurrent);
        pageObject.setPageSize(pageSize);
        pageObject.setRecords(workDayList);
        //5.返回封装结果
        return pageObject;
    }

    @Override
    public int addObject(WorkDay entity) {
        //1.校验参数有效性
        if (entity==null)
            throw new IllegalArgumentException("新增对象不能为空");
        if (StringUtils.isEmpty(entity.getYear()))
            throw new IllegalArgumentException("年度不能为空");
        //2.执行保存工作日信息
        int rows = workDayMapper.insertSelective(entity);
        if (rows==0)
            throw new ServiceException("保存失败");
        //3.返回结果
        return rows;
    }

    @Override
    public int updateObject(WorkDay entity) {
        //1.校验参数有效性
        if (entity==null)
            throw new IllegalArgumentException("修改对象不能为空");
        if (StringUtils.isEmpty(entity.getYear()))
            throw new IllegalArgumentException("年度不能为空");
        //2.基于id执行修改工作日信息
        int rows = workDayMapper.updateByPrimaryKeySelective(entity);
        if (rows==0)
            throw new ServiceException("系统查询不到相应对象");
        //3.返回结果
        return rows;
    }

    @Override
    public int deleteObjects(Integer... ids) {
        //1.校验参数有效性
        if (ids.length==0)
            throw new IllegalArgumentException("id值不能为空");
        for (Integer id : ids) {
            if (id < 0)
                throw new IllegalArgumentException("id值参数不合法，id="+id);
        }
        //2.基于id删除工作日信息
        int rows = 0;
        for (Integer id : ids) {
            rows = workDayMapper.deleteByPrimaryKey(id);
            if (rows==0)
                throw new ServiceException("系统查询不到相应对象");
        }
        //3.返回结果
        return rows;
    }

}
