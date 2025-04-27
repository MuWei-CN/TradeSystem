package com.bistu.exr.service.iservice;

import com.bistu.exr.dao.model.User;

import java.util.List;

public interface UserService {
    User searchUserById(Long id);
    Long loginService(User user) throws Exception;
    Long registerService(User user) throws Exception;
    List<User> getAllPendings() throws Exception;
}
