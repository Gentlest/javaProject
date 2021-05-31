package com.project.composite.exception;

import com.project.composite.constant.ResultCode;
import lombok.Getter;

/**
 * 自定义异常
 *
 * @Author Gentlest
 * @Date 2021/3/3 16:49
 */
@Getter
public class CustomException extends RuntimeException {
    /**
     * 状态码
     */
    private final Integer code;
    /**
     * 错误信息
     */
    private final String message;

    /**
     * 自定义异常
     *
     * @param status 返回枚举对象
     */
    public CustomException(ResultCode status) {
        super(status.getMessage());
        this.code = status.getCode();
        this.message = status.getMessage();
    }

    /**
     * @param code    状态码
     * @param message 错误信息
     */
    public CustomException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
