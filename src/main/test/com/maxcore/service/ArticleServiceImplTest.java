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
}