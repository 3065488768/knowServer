package com.example.know.service.impl;

import com.alibaba.fastjson2.util.DateUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.know.dao.BookDao;
import com.example.know.dao.BookTypeDao;
import com.example.know.entity.Book;
import com.example.know.service.BookService;
import com.example.know.util.AjaxResult;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 书籍业务实现层
 * @author bookWorm 
 * */
@Service
public class BookServiceImpl implements BookService {
    @Resource
    private BookDao bookDao;

    @Resource
    private BookTypeDao bookTypeDao;
    @Override
    public AjaxResult getBookByNewOrder() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("status",'0');
        queryWrapper.orderByDesc("create_time");
        PageHelper.startPage(0,12);
        List list = bookDao.selectList(queryWrapper);
        return AjaxResult.success(list);
    }

    @Override
    public AjaxResult getBookByHotOrder() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("status",'0');
        queryWrapper.orderByDesc("heat_degree");
        PageHelper.startPage(0,12);
        List list = bookDao.selectList(queryWrapper);
        return AjaxResult.success(list);
    }

    @Override
    public AjaxResult getBookByLikeOrder() {
        return AjaxResult.success(bookDao.getBookByLikeOrder());
    }

    @Override
    public AjaxResult getBookByCollectionOrder() {
        return AjaxResult.success(bookDao.getBookByCollectionOrder());
    }

    @Override
    public AjaxResult getBookByExpectOrder() {
        PageHelper.startPage(0,12);
        return AjaxResult.success(bookDao.getBookByExpectOrder());
    }

    @Override
    public AjaxResult getBookOfRecommend() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("status",'0');
        queryWrapper.orderByDesc("create_time");
        PageHelper.startPage(0,20);
        List list = bookDao.selectList(queryWrapper);
        return AjaxResult.success(list);
    }

    @Override
    public AjaxResult getBookType() {
        QueryWrapper queryWrapper = new QueryWrapper();
        return AjaxResult.success(bookTypeDao.selectList(queryWrapper));
    }

    @Override
    public AjaxResult getBookByCondition(int bookType, int status, int order, String startTime, String endTime,int startPage) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if(bookType != 0){ queryWrapper.eq("book_type_id",bookType);}
        queryWrapper.eq("status",status);
        if(order == 1){
            queryWrapper.orderByDesc("create_time");
        }else if(order == 2){
            queryWrapper.orderByDesc("heat_degree");
        }
        if(!startTime.isBlank() && !endTime.isBlank()){
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
            queryWrapper.apply(true, "create_time between '"+ dateFormat.format(DateUtils.parseDate(startTime + " 00:00:00")) +"' and '" + dateFormat.format(DateUtils.parseDate(endTime + " 23:59:59")) + "'");
        }
        int  size = bookDao.selectList(queryWrapper).size();

        //每页20条
        PageHelper.startPage(startPage,18);
        List list = bookDao.selectList(queryWrapper);
        Map map = new HashMap();
        map.put("size",size);
        map.put("books",list);
        return AjaxResult.success(map);
    }

    @Override
    public AjaxResult updateBookType(Book book) {
        return AjaxResult.success(bookDao.updateById(book));
    }

    @Override
    public AjaxResult addBook(Book book) {
        return AjaxResult.success(bookDao.insert(book));
    }

    @Override
    public Long getCountNumber() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("status",'0');
        return bookDao.selectCount(queryWrapper);
    }
}
