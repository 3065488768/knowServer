package com.example.know.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 私信
 * @author bookWorm
 */
@Data
@TableName("letter")
public class Letter {
    @TableId("letter_id")
    private int letterId;

    @TableField("send_id")
    private int sendId;

    @TableField("recipient_id")
    private int recipientId;

    @TableField("status")
    private char status;

    @TableField("content")
    private String content;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Date createTime;
}
