package com.bistu.exr.resultinfo;

/**
 * 返回码
 */

// 返回码枚举类，包括成功、失败、未授权、未找到、服务器内部错误...
public enum ReturnCode {
    SUCCESS(200, "请求成功"),
    FAIL(400, "请求失败"),
    UNAUTHORIZED(401, "授权失败"),
    NOT_FOUND(404, "not found"),
    INTERNAL_SERVER_ERROR(500, "服务器错误"),
    DATABASE_OPERATION_ERROR(533, "数据库操作错误"),
    USERNAME_ALREADY_EXISTS(440, "用户名已存在"),
    MOBILE_ALREADY_EXISTS(441, "手机号不可重复注册"),
    EMAIL_ALREADY_EXISTS(442, "邮箱不可重复注册"),;

    private int code;
    private String message;

    ReturnCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
