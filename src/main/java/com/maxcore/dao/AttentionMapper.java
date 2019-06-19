package com.maxcore.dao;

import com.maxcore.entity.Attention;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
public interface AttentionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Attention record);

    Attention selectByPrimaryKey(Integer id);

    List<Attention> selectAll();

    int updateByPrimaryKey(Attention record);



}