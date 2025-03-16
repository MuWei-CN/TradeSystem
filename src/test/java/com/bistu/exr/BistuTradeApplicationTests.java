package com.bistu.exr;

import com.bistu.exr.controller.test;
import com.bistu.exr.mapper.UserMapper;
import com.bistu.exr.model.CommonUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BistuTradeApplicationTests {
    @Autowired
    private UserMapper userlist;
    @Test
    void contextLoads() {

    }

}
