package com.maxcore.controller;

import com.maxcore.entity.Article;
import com.maxcore.service.ArticleServiceImpl;
import com.maxcore.util.ResponseResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    public ResponseResult getArticleDetail(Integer id, Integer userId) throws Exception {
        return articleServiceImpl.getArticleDetail(id, userId);
    }

    @ApiOperation(value = "喜欢/取消喜欢")
    @GetMapping(value = "checkLikeOrNot")
    public ResponseResult checkLikeOrNot(Integer articleId, Integer userId) {
        return articleServiceImpl.likeOrNot(articleId, userId);
    }

    @ApiOperation(value = "收藏/取消收藏")
    @GetMapping(value = "checkCollectOrNot")
    public ResponseResult checkCollectOrNot(Integer articleId, Integer userId) {
        return articleServiceImpl.checkCollectOrNot(articleId, userId);
    }

    @ApiOperation(value = "发表文章评论")
    @PostMapping(value = "addReply")
    public ResponseResult addReply(Integer userId, Integer articleId, String content) {
        return articleServiceImpl.addReply(userId, articleId, content);
    }

    @ApiOperation(value = "发布文章")
    @PostMapping(value = "addArticle")
    public ResponseResult addArticle(Integer userId, String content, String title,String[]imgs) {
        return articleServiceImpl.addArticle(userId, content, title,imgs);
    }
}
