package com.bistu.exr.dao.dataEnum.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum UserTypeEnum {
    PERSONAL(0),
    ADMIN(1),
    BUSINESS(2);

    private int code;
}
