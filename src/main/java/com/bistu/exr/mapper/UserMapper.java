package com.bistu.exr.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bistu.exr.model.CommonUser;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper extends BaseMapper<CommonUser> {

}