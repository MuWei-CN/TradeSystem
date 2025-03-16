package com.bistu.exr.resultinfo;

import lombok.Builder;
import lombok.Data;

/**
 * 返回信息
 */

// 标准化返回信息，包括返回码、返回信息、返回数据
@Data
@Builder
public class ResultInfo<T> {
    private int code;
    private String message;
    private T data;

    public static <T> ResultInfo<T> success(T data) {
        return ResultInfo.<T>builder()
                .code(ReturnCode.SUCCESS.getCode())
                .message(ReturnCode.SUCCESS.getMessage())
                .data(data)
                .build();
    }

    public static <T> ResultInfo<T> fail(int code, String message) {
        return ResultInfo.<T>builder()
                .code(code)
                .message(message)
                .build();
    }
}
