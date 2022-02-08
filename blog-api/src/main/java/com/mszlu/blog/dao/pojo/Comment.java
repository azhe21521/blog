package com.mszlu.blog.dao.pojo;

import lombok.Data;

/**
 * @author lum
 * @date 2021/9/3
 */

@Data
public class Comment {
    private Long id;

    private String content;

    private Long createDate;

    private Long articleId;

    private Long authorId;

    private Long parentId;

    private Long toUid;

    private Integer level;
}

