package com.example.know.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 喜欢
 * @author bookWorm
 */
@Data
@TableName("like")
public class Like {
    @TableId("like_id")
    private int likeId;

    @TableField("liked_id")
    private int likedId;

    @TableField("like_type")
    private char likeType;

    @TableField("like_by")
    private int likeBy;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Date createTime;
}
