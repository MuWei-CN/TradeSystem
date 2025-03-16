package com.bistu.exr.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bistu.exr.dao.model.CommonUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

// Mapper注解，标识这是一个Mapper接口，用于操作数据库，由Mybatis-Plus框架扫描并生成实现类。
// 继承BaseMapper接口，BaseMapper是Mybatis-Plus提供的一个接口，提供了一些基本的增删改查方法
// 泛型为CommonUser，表示这个Mapper接口操作的是CommonUser表
@Mapper
public interface CommonUserMapper extends BaseMapper<CommonUser> {

}