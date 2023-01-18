package com.example.know.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.know.entity.Access;
import org.apache.ibatis.annotations.Mapper;

/**
 * 访问帖子记录
 * @author bookWorm
 */
@Mapper
public interface AccessDao extends BaseMapper<Access> {
}
