package com.example.know.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.know.entity.Token;
import org.apache.ibatis.annotations.Mapper;

/**
 * token
 * @author bookWorm
 */
@Mapper
public interface TokenDao extends BaseMapper<Token> {
}
