package com.example.know.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 书籍表
 * @author bookWorm
 */
@Data
@TableName("book")
public class Book {
    @TableId("book_id")
    private int bookId;

    @TableField("book_name")
    private String bookName;

    @TableField("book_type_id")
    private int bookTypeId;

    @TableField("status")
    private char status;

    @TableField("author")
    private String author;

    @TableField("contributor")
    private int contributor;

    @TableField("img_url")
    private String imgUrl;

    @TableField("heat_degree")
    private int heatDegree;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "update_time",fill = FieldFill.UPDATE)
    private Date updateTime;

    @TableField("remark")
    private String remark;
}
