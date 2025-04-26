package com.bistu.exr.configuration;

import com.bistu.exr.interceptor.AccessInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 添加拦截器，过滤登录和注册接口
@Configuration
public class InterceptConfig implements WebMvcConfigurer {
    @Autowired
    private AccessInterceptor accessInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(accessInterceptor)
                .excludePathPatterns("api/user/login","api/user/register");
    }
}
