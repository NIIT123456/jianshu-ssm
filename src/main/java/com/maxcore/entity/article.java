package com.maxcore.entity;

import lombok.Data;

/**
 * 文章实体类
 */
@Data
public class article {
    private Integer id;
    private String title;//标题
    private String writer;//作者
    private String content;//内容
    private Integer words;//字数
    private Integer like_num;//被喜欢的总数
    private Integer reads;//阅读数
}
