package com.bistu.exr.controller;

import com.bistu.exr.dao.mapper.CommonUserMapper;
import com.bistu.exr.dao.model.CommonUser;
import com.bistu.exr.resultinfo.ResultInfo;
import com.bistu.exr.resultinfo.ReturnCode;
import com.bistu.exr.service.SImpl.CommonUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 示例文件
 */

// Controller注解，标识这是一个Controller类, 用于处理http请求
@RestController
public class test {
    // Autowired注解，自动装配，将CommonUserServiceImpl类的实例注入到这里
    @Autowired
    private CommonUserServiceImpl userlist;

    // RequestMapping注解，标识这是一个处理http请求的方法，路径为/hello
    // 标准化返回信息，返回值为ResultInfo<String>
    // ResultInfo是自定义的一个类，用于封装返回信息
    @RequestMapping("/hello")
    public ResultInfo<String> hello(@RequestParam String name) {
        // 调用CommonUserServiceImpl类的getUserByName方法，返回CommonUser对象
        // CommonUser对象是一个数据库表的映射类，对应数据库表CommonUser
        CommonUser user;
        if ((user = userlist.getUserByName(name) )!= null) {
            return ResultInfo.success(user.toString());
        } else {
            return ResultInfo.fail(ReturnCode.FAIL.getCode(), ReturnCode.FAIL.getMessage());
        }
    }
}
