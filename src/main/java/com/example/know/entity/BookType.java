package com.example.know.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 书籍类别
 * @author bookWorm
 */
@Data
@TableName("book_type")
public class BookType {
    @TableId("book_type_id")
    private int bookTypeId;

    @TableField("book_type_name")
    private String bookTypeName;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Date createTime;
}
