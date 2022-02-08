package com.mszlu.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mszlu.blog.dao.mapper.CommentMapper;
import com.mszlu.blog.dao.pojo.Comment;
import com.mszlu.blog.dao.pojo.SysUser;
import com.mszlu.blog.service.CommentService;
import com.mszlu.blog.service.SysUserService;
import com.mszlu.blog.vo.CommentVo;
import com.mszlu.blog.vo.Result;
import com.mszlu.blog.vo.UserVo;
import javafx.scene.input.DataFormat;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private SysUserService sysUserService;

    @Override
    public Result commentByArticleId(long articleId) {
        LambdaQueryWrapper<Comment> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(Comment::getArticleId,articleId);
        queryWrapper.eq(Comment::getLevel,1);
        List<Comment> comments = commentMapper.selectList(queryWrapper);
        List<CommentVo>commentVoList=coplList(comments);

        return Result.success(commentVoList);
    }

    private List<CommentVo> coplList(List<Comment> comments) {
        List<CommentVo>commentVoList=new ArrayList<>();
        for (Comment comment : comments) {
            commentVoList.add(copy(comment));;
        }
        return commentVoList;
    }

    private CommentVo copy(Comment comment) {

        CommentVo commentVo=new CommentVo();
        BeanUtils.copyProperties(comment,commentVo);
        commentVo.setCreateDate(new DateTime(comment.getCreateDate()).toString("yyyy-MM-dd HH:mm"));
        Long authorId = comment.getAuthorId();
        UserVo userVo = this.sysUserService.findUserVoById(authorId);

        return commentVo;
    }

}
