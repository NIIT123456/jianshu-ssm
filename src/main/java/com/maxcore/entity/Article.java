package com.maxcore.entity;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public class Article {
    private Integer id;

    private Integer userId;

    private String title;

    private Date createTime;

    private String content;
    private List<Reply> replies;
    private int replyNumber;
 private int likeNumber;
 private List imgs;
private Integer isLike;
private Integer isCollect;
private Integer readNumber;
private Integer isDelete;

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getReadNumber() {
        return readNumber;
    }

    public void setReadNumber(Integer readNumber) {
        this.readNumber = readNumber;
    }

    public Integer getIsCollect() {
        return isCollect;
    }

    public void setIsCollect(Integer isCollect) {
        this.isCollect = isCollect;
    }

    public Integer getIsLike() {
        return isLike;
    }

    public void setIsLike(Integer isLike) {
        this.isLike = isLike;
    }

    public List getImgs() {
        return imgs;
    }

    public void setImgs(List imgs) {
        this.imgs = imgs;
    }

    public int getLikeNumber() {
        return likeNumber;
    }

    public void setLikeNumber(int likeNumber) {
        this.likeNumber = likeNumber;
    }

    public int getReplyNumber() {
        return replyNumber;
    }

    public void setReplyNumber(int replyNumber) {
        this.replyNumber = replyNumber;
    }

    private String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", createTime=" + createTime +
                ", content='" + content + '\'' +
                ", replies=" + replies +
                ", replyNumber=" + replyNumber +
                ", likeNumber=" + likeNumber +
                ", imgs=" + imgs +
                ", isLike=" + isLike +
                ", isCollect=" + isCollect +
                ", readNumber=" + readNumber +
                ", isDelete=" + isDelete +
                ", time='" + time + '\'' +
                '}';
    }
}