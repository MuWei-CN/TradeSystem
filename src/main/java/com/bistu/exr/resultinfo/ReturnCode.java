package com.bistu.exr.resultinfo;

/**
 * 返回码
 */

// 返回码枚举类，包括成功、失败、未授权、未找到、服务器内部错误...
public enum ReturnCode {
    SUCCESS(200, "success"),
    FAIL(400, "fail"),
    UNAUTHORIZED(401, "unauthorized"),
    NOT_FOUND(404, "not found"),
    INTERNAL_SERVER_ERROR(500, "internal server error");

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
