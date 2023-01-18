package com.example.know.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author bookWorm
 */
@Data
@TableName(value = "comment")
public class Comment {
    @TableId(value = "comment_id")
    private Integer commentId;

    @TableField(value = "commentable_id")
    private String commentableId;

    @TableField(value = "commentable_type")
    private char commentableType;

    @TableField(value = "comment_by")
    private int commentBy;

    @TableField(value = "content")
    private String content;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "delete_time")
    private Date deleteTime;
}
