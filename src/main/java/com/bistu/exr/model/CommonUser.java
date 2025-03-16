package com.bistu.exr.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("`commonuser`")
public class CommonUser {
    @TableId("name")
    private String name;
    private String password;

    CommonUser(){}
    CommonUser(String name){
        this.name = name;
    }
    CommonUser(String name,String password){
        this.name = name;
        this.password = password;
    }
}
