package com.sz.serviceImpl;

import com.sz.common.vo.PageObject;
import com.sz.dao.CustomerMapper;
import com.sz.exception.ServiceException;
import com.sz.pojo.Customer;
import com.sz.pojo.Menus;
import com.sz.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public PageObject<Customer> findPageObjects(String cname, Integer pageCurrent,Integer ctype, Integer cstatus) {
        //1.校验参数合法性
        if (pageCurrent==null||pageCurrent<=0)
            throw new ServiceException("请选择页数");
        //2.依据条件获取总记录数
        int rowCount = customerMapper.getRowCount(cname,ctype,cstatus);
        if (rowCount==0)
            throw new ServiceException("系统没有查询到相应记录");
        //3.计算startIndex的值
        int pageSize = 10;
        int startIndex = (pageCurrent-1)*pageSize;
        //4.依据条件获取当前页数
        List<Customer> customerList = customerMapper.findPageObjects(cname, startIndex, pageSize);
        //5.封装数据
        PageObject<Customer> pageObject = new PageObject<>();
        pageObject.setRowCount(rowCount);
        pageObject.setPageSize(pageSize);
        pageObject.setPageCurrent(pageCurrent);
        pageObject.setRecords(customerList);
        //6.返回结果集
        return pageObject;
    }



    @Override
    public int addObject(Customer entity) {
        //1.校验参数合法性
        if (entity==null)
            throw new IllegalArgumentException("录入对象不能为空");
        //2.添加默认状态：激活（0）
        entity.setCstatus(0);
        //3.执行录入新客户信息
        int rows = customerMapper.insertSelective(entity);
        if (rows==0)
            throw new ServiceException("录入新客户失败！");
        //4.返回结果
        return rows;
    }

    @Override
    public int updateObject(Customer entity) {
        //1.校验参数合法性
        if (entity==null)
            throw new IllegalArgumentException("编辑对象不能为空");
        //2.执行编辑客户信息
        int rows = customerMapper.updateByPrimaryKeySelective(entity);
        if (rows==0)
            throw new ServiceException("系统没有查询到该对象");
        //3.返回结果
        return rows;
    }

    @Override
    public int deleteObjects(Integer... ids) {
        int fhjg = 1;
        //1.校验参数合法性
        if (ids!=null) {
            for (int i=0;i<ids.length;i++) {
                if (ids[i]<0)
                    throw new IllegalArgumentException("参数集合ids中有错误");
            }
        }else
            throw new IllegalArgumentException("删除对象不能为空");
        //2.判断批量删除对象是否存在
        for (int a=0;a<ids.length;a++) {
            Customer customercs = customerMapper.selectByPrimaryKey(ids[a]);
            if (customercs==null)
                throw new ServiceException("错误：系统无法查询到id："+ids[a]+"对应的对象");
        }
        //3.执行批量删除
        for (int b=0;b<ids.length;b++) {
            int rows = customerMapper.deleteByPrimaryKey(ids[b]);
            if (rows==0) {
                fhjg = 0;
                throw new ServiceException("无法查询到该对象");
            }
        }
        //4.返回成功结果
        return fhjg;
    }

    @Override
    public int statusById(Integer id, Integer status) {
        //1.校验参数有效性
        if (id==null||id<0)
            throw new IllegalArgumentException("参数id值有误，id="+id);
        if (status!=0&&status!=1)
            throw new IllegalArgumentException("参数status值有误,status="+status);
        //2.执行修改客户状态
        int rows = customerMapper.statusById(id, status);
        if (rows==0)
            throw new ServiceException("无法查询到该对象");
        //3.返回结果
        return rows;
    }
}
