package com.maxcore.dao;

import com.maxcore.entity.Collect;
import java.util.List;

public interface CollectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Collect record);

    Collect selectByPrimaryKey(Integer id);

    List<Collect> selectAll();

    int updateByPrimaryKey(Collect record);
}