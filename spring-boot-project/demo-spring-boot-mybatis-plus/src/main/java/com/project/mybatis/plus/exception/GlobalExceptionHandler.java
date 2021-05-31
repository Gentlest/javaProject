package com.project.mybatis.plus.exception;

import com.project.mybatis.plus.common.ResultVo;
import com.project.mybatis.plus.constant.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理
 *
 * @Author Gentlest
 * @Date 2021/3/23 14:18
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 处理自定义异常
     *
     * @param be 异常
     * @return ResultVo
     */
    @ResponseBody
    @ExceptionHandler(value = BusinessException.class)
    public ResultVo customExceptionHandler(BusinessException be) {
        log.info("【BusinessException】 --->{},{}", be.getErrorMsg(), be);
        return ResultVo.ofError(be);
    }

    /**
     * 处理其他异常
     *
     * @param e 异常
     * @return ResultVo
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResultVo otherExceptionHandler(Exception e) {
        log.info("【Exception】--->{},{}", e.getMessage(), e);
        return ResultVo.ofStatus(ResultCode.INTERNAL_SERVER_ERROR);
    }
}
