package com.mszlu.blog.controller;
import com.mszlu.blog.service.ArticleService;
import com.mszlu.blog.vo.Result;
import com.mszlu.blog.vo.params.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
/**
* 分页查询，文章列表
 *
* */
    @RequestMapping
    public Result listArticle(@RequestBody PageParams pageParams){
        return articleService.listArticle(pageParams);
    }

    /**
     *
     * @return
     */
    @RequestMapping("hot")
    public Result hotArticle(){
        int limit=5;
        return articleService.hotArticle(limit);
    }

    /**
     *
     * @return
     */
    @RequestMapping("new")
    public Result newArticle(){
        int limit=5;
        return articleService.newArticle(limit);
    }



}
