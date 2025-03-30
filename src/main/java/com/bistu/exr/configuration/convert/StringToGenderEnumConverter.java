package com.bistu.exr.configuration.convert;

import com.bistu.exr.dao.dataEnum.User.GenderEnum;
import org.springframework.core.convert.converter.Converter;

public class StringToGenderEnumConverter implements Converter<String, GenderEnum> {
    @Override
    public GenderEnum convert(String source) {
        try {
            return GenderEnum.valueOf(source.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null; // or throw an appropriate exception
        }
    }
}
