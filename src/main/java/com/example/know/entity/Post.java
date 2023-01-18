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
@TableName(value = "post")
@Data
public class Post {
    @TableId(value = "post_id")
    private int postId;

    @TableField(value = "post_title")
    private String postTitle;

    @TableField(value = "post_content")
    private String postContent;

    @TableField(value = "plate_id")
    private int plateId;

    @TableField(value = "post_type")
    private char postType;

    @TableField(value = "status")
    private char status;

    @TableField(value = "heat_degree")
    private int degreeOfHeat;

    @TableField(value = "create_by")
    private int createBy;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "audit_time")
    private Date auditTime;
}
