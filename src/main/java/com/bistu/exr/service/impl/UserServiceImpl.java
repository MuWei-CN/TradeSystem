package com.bistu.exr.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bistu.exr.dao.mapper.UserMapper;
import com.bistu.exr.dao.model.User;
import com.bistu.exr.service.iservice.UserService;
import com.bistu.exr.util.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.bistu.exr.dao.dataEnum.User.StatusEnum.PENDING;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User searchUserById(Long id){
        return userMapper.selectById(id);
    }
    @Override
    public Long registerService(User user) throws Exception {
        userMapper.insert(user);
        return user.getUserId();
    }

    @Override
    public Long loginService(User user) throws Exception {
        QueryWrapper<User> parma = new QueryWrapper<>();
        parma.eq("username",user.getUsername());
        User realuser = userMapper.selectOne(parma);
        if (MD5Util.passwordIsTrue(user.getPassword(),realuser.getPassword()))
            return realuser.getUserId();
        return -1L;
    }

    @Override
    public List<User> getAllPendings() throws Exception {
        QueryWrapper<User> parma = new QueryWrapper<>();
        parma.eq("status",PENDING);
        return userMapper.selectList(parma);
    }
}
