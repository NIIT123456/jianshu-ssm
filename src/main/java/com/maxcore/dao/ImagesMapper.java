package com.maxcore.dao;

import com.maxcore.entity.Images;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.List;
public interface ImagesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Images record);

    Images selectByPrimaryKey(Integer id);

    List<Images> selectAll();

    int updateByPrimaryKey(Images record);

//    文章图片
    @Select("select * from t_images where article_id=#{articleId}")
    List<Images>getArticleImgs(@Param("articleId") Integer articleId);
}