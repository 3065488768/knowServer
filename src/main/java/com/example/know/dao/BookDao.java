package com.example.know.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.know.entity.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 书籍
 * @author bookWorm
 */
@Mapper
public interface BookDao extends BaseMapper<Book> {

    /**
     * 获得喜欢的书籍队列进行排行
     * @return
     * */
    public List getBookByLikeOrder();

    /**
     * 获取收藏的书籍进行排行
     * @return
     * */
    public List getBookByCollectionOrder();

    /**
     * 获取期待的书籍进行排行
     * @return
     * */
    public List getBookByExpectOrder();
}
