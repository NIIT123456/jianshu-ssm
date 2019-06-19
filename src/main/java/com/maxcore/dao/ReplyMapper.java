package com.maxcore.dao;

import com.maxcore.entity.Reply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
public interface ReplyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Reply record);

    Reply selectByPrimaryKey(Integer id);

    List<Reply> selectAll();

    int updateByPrimaryKey(Reply record);
//文章的评论
    List<Reply>getRepliesByArticleId(Integer id);

//    统计回复/喜欢数量
    @Select("SELECT COUNT(${column}) FROM ${table} WHERE ${statusColumn}=0 AND ${column}=#{id}")
    int count(@Param("column") String column,@Param("table") String table,
              @Param("statusColumn")String statusColumn,@Param("id")Integer id);
}