package com.project.jpa.exception;

import com.project.jpa.constant.StatusEnum;

/**
 * @Author Gentlest
 * @Description 页面解析异常
 * @Date 2021/2/27 16:11
 */
public class PageException extends BaseException {
    public PageException(StatusEnum status) {
        super(status);
    }

    public PageException(Integer code, String message) {
        super(code, message);
    }
}
