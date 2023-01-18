package com.example.know.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 通知
 * @author bookWorm
 */
@Data
@TableName("notice")
public class Notice {
    @TableId("notice_id")
    private int noticeId;

    @TableField("notice_content")
    private String noticeContent;

    @TableField("notice_by")
    private int noticeBy;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Date createTime;
}
