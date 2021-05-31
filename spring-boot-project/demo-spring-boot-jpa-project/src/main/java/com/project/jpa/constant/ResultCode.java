package com.project.jpa.constant;

import lombok.Getter;

/**
 * @Author Gentlest
 * @Description 状态码枚举
 * @Date 2021/3/2 10:39
 */
@Getter
public enum ResultCode {
    /**
     * 请求成功
     */
    SUCCESS(2000, "请求成功"),
    /**
     * 参数无效
     */
    PARAM_IS_VALID(1001, "参数无效"),
    /**
     * 参数为空
     */
    PARAM_IS_BLANK(1002, "参数为空"),
    /**
     * 参数类型错误
     */
    PARAM_TYPE_ERROR(1003, "参数类型错误"),
    /**
     * 参数缺失
     */
    PARAM_IS_MISSING(1003, "参数缺失"),
    /**
     * 用户名或密码错误
     */
    USER_LOGIN_FAIL(2001, "用户名或密码错误"),
    /**
     * 用户未登录
     */
    USER_LOGIN_ERROR(2002, "用户未登录,访问路径需要验证,请登录"),
    /**
     * 账号已被禁用
     */
    USER_ACCOUNT_ERROR(2003, "账号已被禁用"),
    /**
     * 账号不存在
     */
    USER_NOT_EXISTS(2004, "账号不存在"),
    /**
     * 账号已存在
     */
    USER_IS_EXISTS(2005, "账号已存在"),

    /**
     * 请求错误
     */
    FAILED(5000, "请求错误");

    /**
     * 状态码
     */
    private final Integer code;
    /**
     * 内容
     */
    private final String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
