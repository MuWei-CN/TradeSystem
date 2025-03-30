package com.bistu.exr.dao.dataEnum.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum StatusEnum {
    PENDING(0, "待审核"),
    ACTIVE(1, "已激活"),
    BANNED(2, "已封禁");

    private int code;
    private String description;
}
