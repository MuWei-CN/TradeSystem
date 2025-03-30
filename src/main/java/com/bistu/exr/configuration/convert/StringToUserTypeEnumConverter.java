package com.bistu.exr.configuration.convert;

import com.bistu.exr.dao.dataEnum.User.UserTypeEnum;
import org.springframework.core.convert.converter.Converter;

public class StringToUserTypeEnumConverter implements Converter<String, UserTypeEnum> {
    @Override
    public UserTypeEnum convert(String source) {
        try {
            return UserTypeEnum.valueOf(source.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null; // or throw an appropriate exception
        }
    }
}
