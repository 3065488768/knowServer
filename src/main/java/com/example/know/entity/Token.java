package com.example.know.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * token表
 * @author bookWorm
 */
@Data
@TableName("token")
public class Token {
    @TableId("token")
    private String token;

    @TableField("userId")
    private int user_id;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "update_time",fill = FieldFill.UPDATE)
    private Date updateTime;

    @TableField("expire_time")
    private Date expireTime;
}
