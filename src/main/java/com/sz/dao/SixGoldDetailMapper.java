package com.sz.dao;

import com.sz.pojo.SixGoldDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SixGoldDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SixGoldDetail record);

    int insertSelective(SixGoldDetail record);

    SixGoldDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SixGoldDetail record);

    int updateByPrimaryKey(SixGoldDetail record);

    List<SixGoldDetail> findPageObjects(
            @Param("workername") String workername,
            @Param("startIndex") Integer startIndex,
            @Param("pageSize") Integer pageSize,
            @Param("months") String months,
            @Param("year") String year);

    int getRowCount(@Param("workername")String workername,@Param("months") String months, @Param("year") String year);

    int selectSame(@Param("IdCard")String IdCard,@Param("month")String month,@Param("year")String year);

    int insertAll(@Param("list")List<SixGoldDetail> list);
}