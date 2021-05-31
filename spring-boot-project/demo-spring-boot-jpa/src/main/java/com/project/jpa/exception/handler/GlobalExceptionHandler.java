package com.project.jpa.exception.handler;

import com.project.jpa.api.ApiResponse;
import com.project.jpa.exception.PageException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Author Gentlest
 * @Description 统一异常处理
 * @Date 2021/2/27 16:00
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = PageException.class)
    public ApiResponse pageException(PageException pageException) {
        return ApiResponse.ofException(pageException);
    }
}
