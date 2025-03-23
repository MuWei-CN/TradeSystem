package com.bistu.exr.service.impl;

import com.bistu.exr.dao.mapper.CommonUserMapper;
import com.bistu.exr.dao.model.CommonUser;
import com.bistu.exr.service.CommonUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.slf4j.Log4jLogger;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Service注解，标识这是一个Service类，用于处理业务逻辑
// Autowired注解，自动装配，将CommonUserMapper类的实例注入到这里
@Slf4j
@Service
public class CommonUserServiceImpl implements CommonUserService {
    @Autowired
    private CommonUserMapper commonUserMapper;

    // 实现CommonUserService接口的getUserByName方法
    // CommonUserMapper的selectById方法是Mybatis-Plus提供的一个方法，用于根据id查询数据库表
    // 返回CommonUser对象
    @Override
    public CommonUser getUserByName(String name) {
        try {
            return commonUserMapper.selectById(name);
        } catch (Exception e) {
            log.error("getUserByName error: " + e.getMessage());
            return null;
        }
    }
}
