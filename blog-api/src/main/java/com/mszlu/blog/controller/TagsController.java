package com.mszlu.blog.controller;

import com.mszlu.blog.service.TagService;
import com.mszlu.blog.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController/*代表接收的是json数据*/
@RequestMapping("tags")
public class TagsController {
    @Autowired
    TagService tagService;

    @GetMapping("hot")
    public Result hot(){
        int limit=6;
        return tagService.hots(limit);
    }

}