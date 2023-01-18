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
@TableName("plate")
public class Plate {
    @TableId("plate_id")
    private int plateId;

    @TableField(value = "plate_name")
    private String plateName;

    @TableField(value = "status")
    private char status;

    @TableField(value = "img_url")
    private String imgUrl;

    @TableField(value = "create_by")
    private int createBy;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "remark")
    private String remark;
}
