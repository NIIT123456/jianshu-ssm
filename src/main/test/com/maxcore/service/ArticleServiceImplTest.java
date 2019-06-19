package com.maxcore.service;

import com.maxcore.util.ResponseResult;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class ArticleServiceImplTest extends BasicTest {
@Autowired
ArticleServiceImpl articleServiceImpl;
    @Test
    public void getArticleDetail() throws Exception {
        ResponseResult detail = articleServiceImpl.getArticleDetail(1, 1);
        System.out.println(detail.toString());
    }
}