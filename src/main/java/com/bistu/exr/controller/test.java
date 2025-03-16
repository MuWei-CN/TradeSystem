package com.bistu.exr.controller;

import com.bistu.exr.mapper.UserMapper;
import com.bistu.exr.model.CommonUser;
import com.bistu.exr.resultinfo.ResultInfo;
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

@RestController
public class test {
    @Autowired
    private UserMapper userlist;

    @RequestMapping("/hello")
    public ResponseEntity<ResultInfo<String>> hello(@RequestParam(required = true, name = "name") String name, @RequestParam(required = false, name = "password") String password){

       return ResponseEntity.ok(ResultInfo.success("hello " + name + "!"));
    }
}
