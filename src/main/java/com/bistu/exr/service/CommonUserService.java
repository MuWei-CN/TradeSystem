package com.bistu.exr.service;

import com.bistu.exr.dao.model.CommonUser;

// CommonUserService接口，定义了获取用户信息的方法
public interface CommonUserService {
    public CommonUser getUserByName(String name);

}
