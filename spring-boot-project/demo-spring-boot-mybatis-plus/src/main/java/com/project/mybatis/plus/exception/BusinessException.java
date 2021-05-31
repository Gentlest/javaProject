package com.project.mybatis.plus.exception;

import com.project.mybatis.plus.constant.ResultCode;
import lombok.Getter;

/**
 * 自定义异常
 *
 * @Author Gentlest
 * @Date 2021/3/23 13:16
 */
@Getter
public class BusinessException extends RuntimeException {
    /**
     * 错误状态码
     */
    private final Integer errorCode;
    /**
     * 错误提示
     */
    private final String errorMsg;

    public BusinessException(ResultCode resultCode) {
        super(resultCode.getMsg());
        this.errorCode = resultCode.getCode();
        this.errorMsg = resultCode.getMsg();
    }

    public BusinessException(Integer errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}
