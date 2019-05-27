package com.sz.serviceImpl;

import com.sz.common.vo.PageObject;
import com.sz.dao.InsuranceMapper;
import com.sz.exception.ServiceException;
import com.sz.pojo.Insurance;
import com.sz.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceServiceImpl implements InsuranceService {

    @Autowired
    private InsuranceMapper insuranceMapper;

    @Override
    public PageObject<Insurance> findPageObjects(Integer pageCurrent) {
        //1.参数合法性校验
        //1.1验证pageCurrent的合法性
        if (pageCurrent==null||pageCurrent<0)
            throw new IllegalArgumentException("页码参数不正确");
        //2.基于条件查询总记录数
        //2.1）执行查询
        int rowCount = insuranceMapper.getRowCount();
        //2.2)验证查询结果，假如rowCount等于0弹出错误提示
        if (rowCount==0)
            throw new ServiceException();
        //3.基于条件查询当前页记录（pageSize定义为10）
        //3.1)定义pageSize
        int pageSize=10;
        //3.2)计算startIndex
        int startIndex=(pageCurrent-1)*pageSize;
        //3.3)执行当前数据的查询操作
        List<Insurance> insuranceList = insuranceMapper.findPageObjects(startIndex, pageSize);
        //4.对分页信息以及当前页记录进行封装
        //4.1)构建PageObject对象
        PageObject<Insurance> pageObject = new PageObject<>();
        //4.2)封装数据
        pageObject.setRowCount(rowCount);
        pageObject.setPageCurrent(pageCurrent);
        pageObject.setPageSize(pageSize);
        pageObject.setRecords(insuranceList);
        //5.返回封装结果
        return pageObject;
    }
}
