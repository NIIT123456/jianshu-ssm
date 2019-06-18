package com.maxcore.mapper;

import com.maxcore.entity.TLike;
import com.maxcore.entity.TLikeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TLikeMapper {
    int countByExample(TLikeExample example);

    int deleteByExample(TLikeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TLike record);

    int insertSelective(TLike record);

    List<TLike> selectByExample(TLikeExample example);

    TLike selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TLike record, @Param("example") TLikeExample example);

    int updateByExample(@Param("record") TLike record, @Param("example") TLikeExample example);

    int updateByPrimaryKeySelective(TLike record);

    int updateByPrimaryKey(TLike record);
}