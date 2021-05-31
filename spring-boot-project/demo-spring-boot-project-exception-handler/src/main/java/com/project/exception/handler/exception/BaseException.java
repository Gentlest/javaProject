package com.project.exception.handler.exception;

import com.project.exception.handler.constant.StatusEnum;
import lombok.Getter;

/**
 * @Author Gentlest
 * @Description 异常基类
 * @Date 2021/2/25 12:52
 */
@Getter
public class BaseException extends RuntimeException {

    private final Integer code;
    private final String message;

    public BaseException(StatusEnum status) {
        super(status.getMessage());
        this.code = status.getCode();
        this.message = status.getMessage();
    }

    public BaseException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
