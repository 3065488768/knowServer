package com.example.know.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 书籍历史
 * @author bookWorm
 */
@Data
@TableName("book_history")
public class BookHistory {
    @TableId("book_history_id")
    private int bookHistoryId;

    @TableField("user_id")
    private int userId;

    @TableField("book_id")
    private int bookId;

    @TableField("progress")
    private int progress;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "update_time",fill = FieldFill.INSERT)
    private Date updateTime;
}
