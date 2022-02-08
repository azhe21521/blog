package com.mszlu.blog.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mszlu.blog.dao.pojo.Tag;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TagMapper extends BaseMapper<Tag> {
    List<Tag> findTagsByArticleId(Long articleId);

    List<Long> findHotsTagId(int limit);

    List<Tag> findTagsByTagIds(List<Long> tagids);
}
