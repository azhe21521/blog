package com.mszlu.blog.service;

import com.mszlu.blog.vo.Result;

public interface CommentService {
    Result commentByArticleId(long articleId);
}
