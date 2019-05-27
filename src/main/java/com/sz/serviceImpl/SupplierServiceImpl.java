package com.sz.serviceImpl;

import com.sz.common.vo.PageObject;
import com.sz.dao.SupplierMapper;
import com.sz.exception.ServiceException;
import com.sz.pojo.Supplier;
import com.sz.pojo.User;
import com.sz.service.SupplierService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierMapper supplierMapper;

    @Override
    public PageObject<Supplier> findPageObjects(String sname, Integer type, Integer sstatus, Integer pageCurrent) {
        //1.参数合法性校验
        //1.1验证pageCurrent的合法性
        if (pageCurrent==0||pageCurrent<0)
            throw new IllegalArgumentException("页码参数不正确");
        //2.基于条件查询总记录数
        //2.1）执行查询
        Integer status = sstatus;
        int rowCount = supplierMapper.getRowCount(sname, type, status);
        //2.2)验证查询结果，假如rowCount等于0弹出错误提示
        if (rowCount==0)
            throw new ServiceException("系统未查询到对应的供应商信息");
        //3.基于条件查询当前页记录（pageSize定义为10）
        //3.1)定义pageSize
        int pageSize=10;
        //3.2)计算startIndex
        int startIndex=(pageCurrent-1)*pageSize;
        //3.3)执行当前数据的查询操作
        List<Supplier> supplierList = supplierMapper.findPageObjects(sname, type, status, startIndex, pageSize);
        //4.对分页信息以及当前页记录进行封装
        //4.1)构建PageObject对象
        PageObject<Supplier> pageObject = new PageObject<>();
        //4.2)封装数据
        pageObject.setRowCount(rowCount);
        pageObject.setPageCurrent(pageCurrent);
        pageObject.setPageSize(pageSize);
        pageObject.setRecords(supplierList);
        //5.返回封装结果
        return pageObject;
    }

    @Override
    public int addObject(Supplier entity) {
        //1.校验参数合法性
        if (entity==null)
            throw new IllegalArgumentException("保存对象不能为空");
        if (StringUtils.isEmpty(entity.getSname()))
            throw new IllegalArgumentException("供应商简称不能为空");
        //2.默认状态为激活
        entity.setSstatus(0);
        //3.执行添加供应商信息
        int rows = supplierMapper.insertSelective(entity);
        //4.判断是否新增成功
        if (rows==0)
            throw new ServiceException("供应商新增失败！！！");
        //5.返回结果
        return rows;
    }

    @Override
    public int updateObject(Supplier entity) {
        //1.校验参数合法性
        if (entity==null)
            throw new IllegalArgumentException("修改对象不能为空");
        if (StringUtils.isEmpty(entity.getSname()))
            throw new IllegalArgumentException("供应商简称不能为空");
        //2.基于id执行修改供应商信息
        int rows = supplierMapper.updateByPrimaryKeySelective(entity);
        //3.判断是否存在id对应的供应商信息
        if (rows==0)
            throw new ServiceException("系统查询不到相应供应商对象");
        //4.返回结果
        return rows;
    }

    @Override
    public int statusById(Integer status, Integer... ids) {
        //1.校验参数合法性
        if (ids.length==0)
            throw new IllegalArgumentException("请选择修改对象");
        if (status!=0&&status!=1)
            throw new IllegalArgumentException("状态值参数不对");
        //2.基于id修改供应商状态
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        String name = user.getUserrealname();
        int rows = supplierMapper.statusById(status,name,ids);
        //3.判断供应商是否存在
        if (rows==0)
            throw new ServiceException("系统查询不到对应的供应商信息");
        //4.返回结果
        return rows;
    }

    @Override
    public int deleteObjects(Integer... ids) {
        int row=1;
        //1.校验参数有效性
        if (ids.length==0)
            throw new IllegalArgumentException("请选择删除对象");
        //2.基于id删除供应商
        for (int i = 0; i < ids.length; i++) {
            int rows = supplierMapper.deleteByPrimaryKey(ids[i]);
            if (rows==0) {
                row = 0;
                throw new ServiceException("系统找不到对应的供应商信息");
            }
        }
        //3.返回结果
        return row;
    }
}
