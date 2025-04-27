package com.bistu.exr.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bistu.exr.dao.mapper.UserMapper;
import com.bistu.exr.dao.model.User;
import com.bistu.exr.service.iservice.UserService;
import com.bistu.exr.util.MD5Util;
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
        QueryWrapper parma = new QueryWrapper<>();
        parma.eq("username",user.getUsername());
        User realuser = userMapper.selectOne(parma);
        if (MD5Util.passwordIsTrue(user.getPassword(),realuser.getPassword()))
            return realuser.getUserId();
        return -1L;
    }
}
