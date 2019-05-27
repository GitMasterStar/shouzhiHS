package com.sz.dao;

import com.sz.pojo.Legalperson;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LegalpersonMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Legalperson record);

    int insertSelective(Legalperson record);

    Legalperson selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Legalperson record);

    int updateByPrimaryKey(Legalperson record);

    List<Legalperson> selectByPrimaryKeyType(Integer legalType);
}