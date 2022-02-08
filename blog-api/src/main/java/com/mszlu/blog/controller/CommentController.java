package com.mszlu.blog.controller;

import com.mszlu.blog.service.CommentService;
import com.mszlu.blog.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("article/{id}")
    public Result findArticleById(@PathVariable("id")long articleId){

        return commentService.commentByArticleId(articleId);
    }
}
