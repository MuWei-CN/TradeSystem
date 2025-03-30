package com.bistu.exr.service.impl;

import com.bistu.exr.dao.mapper.UserMapper;
import com.bistu.exr.dao.model.User;
import com.bistu.exr.service.iservice.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public Long registerService(User user) throws Exception {
        userMapper.insert(user);
        return user.getUserId();
    }

    public Long loginService(User user) throws Exception {

        return 0L;
    }
}
