package com.bistu.exr.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bistu.exr.model.CommonUser;
import org.apache.ibatis.annotations.Mapper;

// Mapper注解，标识这是一个Mapper接口，用于操作数据库
// 继承BaseMapper接口，BaseMapper是Mybatis-Plus提供的一个接口，提供了一些基本的增删改查方法
// 泛型为CommonUser，表示这个Mapper接口操作的是CommonUser表
@Mapper
public interface UserMapper extends BaseMapper<CommonUser> {

}