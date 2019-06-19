package com.maxcore.dao;

import com.maxcore.entity.Collect;
import com.maxcore.entity.Like;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
public interface LikeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Like record);

    Like selectByPrimaryKey(Integer id);

    List<Like> selectAll();

    int updateByPrimaryKey(Like record);

    //    判断登录用户是否已经喜欢/不喜欢
    @Select("select * from t_like where user_id=#{userId} and article_id=#{articleId}")
    Like isHasLike(@Param("userId")Integer userId,
                              @Param("articleId")Integer articleId);

    //    判断登录用户是否已收藏/未收藏
    @Select("select * from t_collect where user_id=#{userId} and article_id=#{articleId}")
    Collect isHasCollect(@Param("userId")Integer userId,
                         @Param("articleId")Integer articleId);
}