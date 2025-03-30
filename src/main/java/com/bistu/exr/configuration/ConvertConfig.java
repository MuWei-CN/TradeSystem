package com.bistu.exr.configuration;

import com.bistu.exr.configuration.convert.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class ConvertConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToUserTypeEnumConverter());
        registry.addConverter(new StringToGenderEnumConverter());
    }
}
