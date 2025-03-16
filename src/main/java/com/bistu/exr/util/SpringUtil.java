package com.bistu.exr.util;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Spring工具类
 */

public class SpringUtil {
    private static ConfigurableApplicationContext app;

    public static void setAppContext(ConfigurableApplicationContext context){
        app = context;
    }

    public static ConfigurableApplicationContext getInstance(){
        return app;
    }

}
