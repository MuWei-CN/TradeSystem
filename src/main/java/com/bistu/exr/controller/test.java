package com.bistu.exr.controller;

import com.bistu.exr.mapper.UserMapper;
import com.bistu.exr.model.CommonUser;
import com.bistu.exr.resultinfo.ResultInfo;
import com.bistu.exr.resultinfo.ReturnCode;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 示例文件
 */

// Controller注解，标识这是一个Controller类, 用于处理http请求
@RestController
public class test {
    // Autowired注解，自动注入UserMapper对象
    @Autowired
    private UserMapper userlist;

    // RequestMapping注解，标识这是一个处理http请求的方法，路径为/hello
    // 标准化返回信息，返回值为ResponseEntity<ResultInfo<String>>
    // ResponseEntity是Spring提供的一个类，用于封装http网页状态信息
    // ResultInfo是自定义的一个类，用于封装返回信息
    @RequestMapping("/hello")
    public ResponseEntity<ResultInfo<String>> hello(){
        // 测试，返回错误信息
       return ResponseEntity.internalServerError().body(ResultInfo.fail(ReturnCode.INTERNAL_SERVER_ERROR.getCode(), ReturnCode.INTERNAL_SERVER_ERROR.getMessage()));
    }
}
