package com.kgc.mapper;

import com.kgc.pojo.dept2;
import com.kgc.pojo.dept2Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface dept2Mapper {
    long countByExample(dept2Example example);

    int deleteByExample(dept2Example example);

    int deleteByPrimaryKey(Integer deptno);

    int insert(dept2 record);

    int insertSelective(dept2 record);

    List<dept2> selectByExample(dept2Example example);

    dept2 selectByPrimaryKey(Integer deptno);

    int updateByExampleSelective(@Param("record") dept2 record, @Param("example") dept2Example example);

    int updateByExample(@Param("record") dept2 record, @Param("example") dept2Example example);

    int updateByPrimaryKeySelective(dept2 record);

    int updateByPrimaryKey(dept2 record);
}