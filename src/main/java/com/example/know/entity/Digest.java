package com.example.know.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 书摘
 * @author bookWorm
 */
@Data
@TableName("digest")
public class Digest {
    @TableId("digest_id")
    private int digestId;

    @TableField("digest_content")
    private String digestContent;

    @TableField("book_id")
    private int bookId;

    @TableField("author")
    private int author;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Date createTime;
}
