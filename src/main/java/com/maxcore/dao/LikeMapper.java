package com.maxcore.dao;

import com.maxcore.entity.Collect;
import com.maxcore.entity.Like;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

public interface LikeMapper {
    int deleteByPrimaryKey(Integer id);
//    首次点击喜欢，添加一条记录
    int insert(Like record);

    Like selectByPrimaryKey(Integer id);

    List<Like> selectAll();

    int updateByPrimaryKey(Like record);

    //    判断登录用户是否曾经喜欢过
    @Select("select * from t_like where user_id=#{userId} and article_id=#{articleId}")
    Like isHasLike(@Param("userId")Integer userId,
                              @Param("articleId")Integer articleId);

    //    判断登录用户是否曾经收藏过
    @Select("select * from t_collect where user_id=#{userId} and article_id=#{articleId}")
    Collect isHasCollect(@Param("userId")Integer userId,
                         @Param("articleId")Integer articleId);

//    切换点赞/取消点赞状态
    int checkLikeOrNot(Map<String,Object> map);
//    切换收藏/取消收藏状态
    int checkCollectOrNot(Map<String,Object> map);


}