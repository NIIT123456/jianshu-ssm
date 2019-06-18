package com.maxcore.mapper;

import com.maxcore.entity.TCollectionArticle;
import com.maxcore.entity.TCollectionArticleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCollectionArticleMapper {
    int countByExample(TCollectionArticleExample example);

    int deleteByExample(TCollectionArticleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TCollectionArticle record);

    int insertSelective(TCollectionArticle record);

    List<TCollectionArticle> selectByExample(TCollectionArticleExample example);

    TCollectionArticle selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TCollectionArticle record, @Param("example") TCollectionArticleExample example);

    int updateByExample(@Param("record") TCollectionArticle record, @Param("example") TCollectionArticleExample example);

    int updateByPrimaryKeySelective(TCollectionArticle record);

    int updateByPrimaryKey(TCollectionArticle record);
}