package com.project.exception.handler.exception;

import com.project.exception.handler.constant.StatusEnum;

/**
 * @Author Gentlest
 * @Description 页面解析异常
 * @Date 2021/2/25 13:36
 */
public class PageException extends BaseException {
    public PageException(StatusEnum status) {
        super(status);
    }

    public PageException(Integer code, String message) {
        super(code, message);
    }
}
