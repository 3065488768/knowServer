package com.example.know.service;

import com.example.know.entity.Book;
import com.example.know.util.AjaxResult;

/**
 * 处理书籍业务
 * @author bookWorm
 */
public interface BookService  {

    /**
     * 获取最新的书籍
     * @return
     * */
    public AjaxResult getBookByNewOrder();

    /**
     * 获取最热的书籍
     * @return
     * */
    public AjaxResult getBookByHotOrder();

    /**
     * 获取最多喜欢的书籍
     * @return
     * */
    public AjaxResult getBookByLikeOrder();

    /**
     * 获取最多收藏的书籍
     * @return
     * */
    public AjaxResult getBookByCollectionOrder();

    /**
     * 获取最期待的书籍
     * @return
     * */
    public AjaxResult getBookByExpectOrder();

    /**
     * 获取推荐的书籍
     * @return
     * */
    public AjaxResult getBookOfRecommend();

    /**
     * 获取书籍类别信息
     * @return
     * */
    public AjaxResult getBookType();

    /**
     * 依据条件进行返回书籍
     * @param bookType 0-全部 后面对应书籍类别顺序
     * @param status 0-正常 1-审核中 2-筹措 3-下架
     * @param order 排序 0-默认 1-最新 2-最热
     * @param startTime 起始时间
     * @param endTime 终止时间
     * @param startPage 起始页码
     * @return
     * */
    public AjaxResult getBookByCondition(int bookType,int status,int order,String startTime,String endTime,int startPage);

    /**
     * 更改书籍类型
     * @param book 书籍信息
     * @return
     * */
    public AjaxResult updateBookType(Book book);

    /**
     * 增加书籍信息
     * @param book 书籍信息
     * @return
     * */
    public AjaxResult addBook(Book book);

    /**
     * 返回表内数据量
     *
     * @return
     */
    public Long getCountNumber();
}
