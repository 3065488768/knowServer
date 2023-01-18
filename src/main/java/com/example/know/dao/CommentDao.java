package com.example.know.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.know.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author bookWorm
 */
@Mapper
public interface CommentDao extends BaseMapper<Comment> {
}
