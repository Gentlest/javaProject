package com.project.exception.handler.constant;

import lombok.Getter;

/**
 * @Author Gentlest
 * @Description 请求状态封装
 * @Date 2021/2/25 12:53
 */
@Getter
public enum StatusEnum {
    /**
     * 请求成功
     */
    OK(200, "请求成功"),
    /**
     * 请求失败
     */
    UNKNOWN_ERROR(500, "服务器出现错误啦");
    /**
     * 状态码
     */
    private final Integer code;
    /**
     * 内容
     */
    private final String message;

    StatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
