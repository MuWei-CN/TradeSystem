package com.bistu.exr.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.bistu.exr.dao.model.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
