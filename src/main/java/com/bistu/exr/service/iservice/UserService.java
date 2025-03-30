package com.bistu.exr.service.iservice;

import com.bistu.exr.dao.model.User;

public interface UserService {
    Long loginService(User user) throws Exception;
    Long registerService(User user) throws Exception;
}
