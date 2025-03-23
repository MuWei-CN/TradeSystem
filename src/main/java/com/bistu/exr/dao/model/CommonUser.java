package com.bistu.exr.dao.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

// @Data注解，自动生成getter、setter、toString等方法
// @TableName注解，表示这个类对应数据库中的commonuser表

@Data
@Builder
@TableName("`commonuser`")
public class CommonUser {
    @TableId("name")
    private String name;
    private String password;
}
