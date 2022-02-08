package com.mszlu.blog.service;

import com.mszlu.blog.vo.Result;
import com.mszlu.blog.vo.params.PageParams;

public interface ArticleService {
    Result listArticle(PageParams pageParams);

    Result hotArticle(int limit);

    Result newArticle(int limit);
}
