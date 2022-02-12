package com.project.mybatis.plus.exception;

import com.project.mybatis.plus.common.ResultVo;
import lombok.Getter;

/**
 * 自定义异常
 *
 * @Author Gentlest
 * @Date 2021/3/23 13:16
 */
@Getter
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 6615311256175426292L;
    /**
     * 错误状态码
     */
    private final Integer errorCode;
    /**
     * 错误提示
     */
    private final String errorMsg;

    public BusinessException(ResultVo resultCode) {
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
