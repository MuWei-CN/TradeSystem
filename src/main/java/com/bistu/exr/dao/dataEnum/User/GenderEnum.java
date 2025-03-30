package com.bistu.exr.dao.dataEnum.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum GenderEnum {
    MALE(0),
    FEMALE(1),
    OTHER(2);

    private int code;
}
