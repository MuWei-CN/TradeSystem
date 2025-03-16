package com.bistu.exr.service.SImpl;

import com.bistu.exr.dao.mapper.CommonUserMapper;
import com.bistu.exr.dao.model.CommonUser;
import com.bistu.exr.service.SInterface.CommonUserService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Service注解，标识这是一个Service类，用于处理业务逻辑
// Autowired注解，自动装配，将CommonUserMapper类的实例注入到这里
@Service
public class CommonUserServiceImpl implements CommonUserService {
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(CommonUserServiceImpl.class);

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
            logger.error("getUserByName error: " + e.getMessage());
            return null;
        }
    }
}
