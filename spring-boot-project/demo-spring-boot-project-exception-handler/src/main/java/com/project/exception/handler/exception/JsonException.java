package com.project.exception.handler.exception;

import com.project.exception.handler.constant.StatusEnum;

/**
 * @Author Gentlest
 * @Description Json序列化异常
 * @Date 2021/2/25 13:35
 */
public class JsonException extends BaseException {
    public JsonException(StatusEnum status) {
        super(status);
    }

    public JsonException(Integer code, String message) {
        super(code, message);
    }
}
