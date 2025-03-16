package com.bistu.exr;

import com.bistu.exr.util.SpringUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@MapperScan("com.bistu.exr.dao")
@SpringBootApplication
public class BistuTradeApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BistuTradeApplication.class, args);
        SpringUtil.setAppContext(context);
    }
}
