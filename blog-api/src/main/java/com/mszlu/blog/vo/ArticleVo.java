package com.mszlu.blog.vo;

import lombok.Data;

import java.util.List;

@Data
public class ArticleVo {

    private Long id;

    private String title;

    private String summary;  //简介

    private int commentCounts;

    private int ViewCounts;

    private int weight;   //置顶

    private String createDate;  //创建时间

    private String author;
    
//暂时不需要
//    private ArticleBodyVo body;

    private List<TagVo> tags;
    
//暂时不需要
//    private List<CategoryVo> categories;
}

