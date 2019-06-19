package com.maxcore.service;

import com.maxcore.dao.*;
import com.maxcore.entity.*;
import com.maxcore.util.MsgConst;
import com.maxcore.util.PageUtil;
import com.maxcore.util.ResponseResult;
import com.maxcore.util.StatusConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl {

    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private ReplyMapper replyMapper;
    @Autowired
    private ImagesMapper imagesMapper;

    public ResponseResult getAllArticleList(Integer currentPage, Integer pageSize) {
        List<Article> articles = articleMapper.selectAll();
        List<Article> articleList = PageUtil.pageDemo(currentPage, pageSize, articles);
        for (Article article : articleList) {
            getLikeReply(article);
        }
        return ResponseResult.succ(articleList, articles.size());
    }
//文章的喜欢数量和收藏数量
    public Article getLikeReply(Article article) {
        String column = "article_id";
        String replyTable = "t_reply";
        String likeTable = "t_like";
        String deleteColumn="is_delete";
        String statusColumn="status";
        int replyCount = replyMapper.count(column, replyTable, deleteColumn,article.getId());
        int likeCount = replyMapper.count(column, likeTable,statusColumn, article.getId());
        article.setReplyNumber(replyCount);
        article.setLikeNumber(likeCount);
        article.setImgs(imagesMapper.getArticleImgs(article.getId()));
        if (article.getCreateTime() != null)
            article.setTime(PageUtil.getDateString(article.getCreateTime()));
        return article;
    }
@Autowired
private LikeMapper likeMapper;
    @Autowired
    private UserDao userDao;
    public ResponseResult getArticleDetail(Integer articleId, Integer userId) throws Exception {
        Article article = articleMapper.selectByPrimaryKey(articleId);
        getLikeReply(article);

//        我是否已经喜欢了该文章，0已喜欢/1未喜欢
        Like like =likeMapper.isHasLike(userId, articleId);
        if (like==null||like.getStatus()==1)
            article.setIsLike(1);
        else
            article.setIsLike(0);
//        我是否已经收藏了该文章，0已收藏/1未收藏
        Collect collect =likeMapper.isHasCollect(userId, articleId);
        if (collect==null||collect.getStatus()==1)
            article.setIsCollect(1);
        else
            article.setIsCollect(0);
//   文章的评论
        List<Reply> replies = replyMapper.getRepliesByArticleId(articleId);
        for (Reply reply:replies)
        {
            if (reply.getReplyTime()!=null)
            reply.setTime(PageUtil.getDateString(reply.getReplyTime()));
            User user = userDao.getUserById(reply.getUserId());
            reply.setUser(user);
        }
        article.setReplies(replies);
        return ResponseResult.success(article);
    }

    public ResponseResult likeOrNot(Integer articleId,Integer userId)
    {
        if (articleId==null||userId==null)
            return ResponseResult.error(StatusConst.ERROR, MsgConst.ID_NULL);
        Like like ;
        like= likeMapper.isHasLike(userId, articleId);
        if (like==null) {
            Like lk = new Like();
            lk.setUserId(userId);
            lk.setArticleId(articleId);
            lk.setStatus(0);
            likeMapper.insert(lk);
            return new ResponseResult(StatusConst.SUCCESS,"已喜欢");
        }
        Map map=new HashMap<>();
        map.put("status",like.getStatus());
        map.put("id",like.getId());
        likeMapper.checkLikeOrNot(map);
        like = likeMapper.selectByPrimaryKey(like.getId());
        if (like.getStatus()==1)
            return new ResponseResult(1,"未喜欢");
        else
            return new ResponseResult(StatusConst.SUCCESS,"已喜欢");

    }

    @Autowired
    private CollectMapper collectMapper;
    public ResponseResult checkCollectOrNot(Integer articleId,Integer userId)
    {
        if (articleId==null||userId==null)
            return ResponseResult.error(StatusConst.ERROR, MsgConst.ID_NULL);
        Collect collect;
        collect= likeMapper.isHasCollect(userId, articleId);
        if (collect==null) {
            Collect coll = new Collect();
            coll.setUserId(userId);
            coll.setArticleId(articleId);
            coll.setStatus(0);
            collectMapper.insert(coll);
            return new ResponseResult(StatusConst.SUCCESS,"已收藏");
        }
        Map map=new HashMap<>();
        map.put("status",collect.getStatus());
        map.put("id",collect.getId());
        likeMapper.checkCollectOrNot(map);
        Collect cl = collectMapper.selectByPrimaryKey(collect.getId());
        if (cl.getStatus()==1)
            return new ResponseResult(1,"未收藏");
        else
            return new ResponseResult(0,"已收藏");

    }
}
