package com.example.know.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 访问帖子记录
 * @author bookWorm
 */
@Data
@TableName(value = "access")
public class Access {
    @TableId(value = "access_id")
    private Integer accessId;

    @TableField(value = "access_ip")
    private String accessIp;

    @TableField(value = "post_id")
    private int postId;

    @TableField(value = "access_by")
    private int accessBy;

    @TableField(value = "access_time",fill = FieldFill.INSERT)
    private Date accessTime;
}
