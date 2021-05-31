package com.project.mybatis.plus.constant;

import lombok.Getter;

/**
 * 错误信息枚举
 *
 * @Author Gentlest
 * @Date 2021/3/23 13:24
 */
@Getter
public enum ResultCode {

    // 数据操作错误定义
    SUCCESS(200, "成功"),
    NO_PERMISSION(403, "你没得权限"),
    NO_AUTH(401, "未登录"),
    NOT_FOUND(404, "未找到该资源!"),
    INTERNAL_SERVER_ERROR(500, "服务器异常请联系管理员"),
    ;

    /**
     * 错误码
     */
    private final Integer code;

    /**
     * 错误信息
     */
    private final String msg;

    ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
