package com.sz.dao;

import com.sz.pojo.SixGoldDetail;
import org.springframework.stereotype.Repository;

@Repository
public interface SixGoldDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SixGoldDetail record);

    int insertSelective(SixGoldDetail record);

    SixGoldDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SixGoldDetail record);

    int updateByPrimaryKey(SixGoldDetail record);
}