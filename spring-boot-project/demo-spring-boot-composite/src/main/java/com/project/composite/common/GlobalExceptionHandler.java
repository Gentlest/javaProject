package com.project.composite.common;

import com.project.composite.constant.ResultCode;
import com.project.composite.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Objects;

/**
 * 统一异常处理
 *
 * @Author Gentlest
 * @Date 2021/3/4 16:38
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 自定义异常处理
     */
    @ExceptionHandler(CustomException.class)
    public ResultVo customException(CustomException customException) {
        log.error("{},{}", customException.getCode(), customException.getMessage());
        return ResultVo.failure(Objects.requireNonNull(ResultCode.getByCode(customException.getCode())));
    }

    /**
     * 通用异常处理
     */
    @ExceptionHandler(value = Exception.class)
    public ResultVo exception(Exception e) {
        e.printStackTrace();
        return ResultVo.failure(ResultCode.FAILED,e.getLocalizedMessage());
    }
}
