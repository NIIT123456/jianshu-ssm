package com.maxcore.service;

import com.maxcore.dao.LikeMapper;
import com.maxcore.util.ResponseResult;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ArticleServiceImplTest extends BasicTest {
@Autowired
ArticleServiceImpl articleServiceImpl;
    @Test
    public void getArticleDetail() throws Exception {
        ResponseResult detail = articleServiceImpl.getArticleDetail(1, 1);
        System.out.println(detail.toString());
    }
    @Autowired
    private LikeMapper likeMapper;

    @Test
    public void checkLikeTest()
    {
        Map<String, Object> map = new HashMap<>();
        map.put("status",1);
        map.put("id",1);
        int i = likeMapper.checkLikeOrNot(map);
        System.out.println(i+"+++++++++");
    }

    @Test
    public void checkLikeOrNot()
    {
        ResponseResult responseResult = articleServiceImpl.likeOrNot(4, 3);
        System.out.println(responseResult.toString());
    }

    @Test
    public void checkCollectOrNot()
    {
        ResponseResult responseResult = articleServiceImpl.checkCollectOrNot(3, 4);
        System.out.println(responseResult.toString());
    }

    @Test
    public void addReplyTest()
    {
        System.out.println(articleServiceImpl.addReply(1,2,"评论内容哈哈").toString());
    }

    @Test
    public void addArticleTest()
    {
        String[]imgs=new String[]{"wwww","bbbb"};
        System.out.println(articleServiceImpl.addArticle(1,"文章内容哈哈2","文章标题2",imgs).toString());
    }
}