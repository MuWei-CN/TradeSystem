package com.bistu.exr.dao.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.bistu.exr.dao.dataEnum.User.GenderEnum;
import com.bistu.exr.dao.dataEnum.User.StatusEnum;
import com.bistu.exr.dao.dataEnum.User.UserTypeEnum;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
@TableName("user")
public class User {
    @TableId(type = IdType.AUTO)
    private Long userId;

    @TableField("username")
    private String username;

    @TableField("password")
    private String password;

    @TableField("user_type")
    private UserTypeEnum userType;

    @TableField("real_name")
    private String realName;

    @TableField("mobile")
    private String mobile;

    @TableField("email")
    private String email;

    @TableField("city")
    private String city;

    @TableField("gender")
    private GenderEnum gender;

    @TableField("bank_account")
    private String bankAccount;

    @TableField("business_license")
    private String businessLicense;

    @TableField("status")
    private StatusEnum status;

    @TableField("created_at")
    private Date createAt;
}
