package com.example.know.controller;

import com.alibaba.fastjson2.util.DateUtils;
import com.example.know.service.impl.BookServiceImpl;
import com.example.know.util.AjaxResult;
import com.example.know.util.DateUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 对于书库的简易信息返回
 * @author bookWorm
 */
@RestController
@RequestMapping("/book")
public class BookController {

    @Resource
    private BookServiceImpl bookService;

    @GetMapping("/getBookByNewOrder")
    public AjaxResult getBookByNewOrder(){
        return bookService.getBookByNewOrder();
    }

    @GetMapping("/getBookByHotOrder")
    public AjaxResult getBookByHotOrder(){
        return bookService.getBookByHotOrder();
    }

    @GetMapping("/getBookByLikeOrder")
    public AjaxResult getBookByLikeOrder(){
        return bookService.getBookByLikeOrder();
    }

    @GetMapping("/getBookByCollectionOrder")
    public AjaxResult getBookByCollectionOrder(){
        return bookService.getBookByCollectionOrder();
    }

    @GetMapping("/getBookByExpectOrder")
    public AjaxResult getBookByExpectOrder(){
        return bookService.getBookByExpectOrder();
    }

    @GetMapping("/getBookType")
     public AjaxResult getBookType(){
        return bookService.getBookType();
    }
    @GetMapping("/getBookByCondition")
    public AjaxResult getBookByCondition(int bookType, int status, int order, String startTime, String endTime, int startPage){
        return bookService.getBookByCondition(bookType,status,order,startTime,endTime,startPage);
    }
}
