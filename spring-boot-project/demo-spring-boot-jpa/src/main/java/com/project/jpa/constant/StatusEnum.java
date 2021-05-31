package com.project.jpa.constant;

import lombok.Getter;

/**
 * @Author Gentlest
 * @Description 封装状态码
 * @Date 2021/2/27 16:01
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
    FAILED(500, "请求失败");

    /**
     * 状态码
     */
    private final Integer code;
    /**
     * 响应内容
     */
    private final String message;

    StatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
