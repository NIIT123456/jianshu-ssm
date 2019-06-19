package com.maxcore.controller;

import com.maxcore.entity.Article;
import com.maxcore.service.ArticleServiceImpl;
import com.maxcore.util.ResponseResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;

@RestController
@RequestMapping(value = "article")
public class ArticleController {

    @Autowired
    private ArticleServiceImpl articleServiceImpl;

    @ApiOperation(value = "所有的文章列表")
    @GetMapping(value = "getAllArticleList")
    public ResponseResult getAllArticleList(Integer currentPage, Integer pageSize) {
        return articleServiceImpl.getAllArticleList(currentPage, pageSize);
    }

    @ApiOperation(value = "文章详情")
    @GetMapping(value = "getArticleDetail")
    public ResponseResult getArticleDetail(Integer id,Integer userId) throws Exception {
        return articleServiceImpl.getArticleDetail(id,userId);
    }
}
