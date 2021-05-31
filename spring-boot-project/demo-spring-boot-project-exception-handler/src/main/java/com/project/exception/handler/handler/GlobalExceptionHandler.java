package com.project.exception.handler.handler;

import com.project.exception.handler.api.ApiResponse;
import com.project.exception.handler.exception.JsonException;
import com.project.exception.handler.exception.PageException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author Gentlest
 * @Description
 * @Date 2021/2/25 13:38
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final String DEFAULT_ERROR_PAGE = "error";

    /**
     * @param jsonException 异常 {@link JsonException}
     */
    @ExceptionHandler(value = JsonException.class)
    @ResponseBody
    public ApiResponse jsonException(JsonException jsonException) {
        log.info("[JsonException]=====> {},{}", jsonException.getCode(), jsonException.getMessage());
        return ApiResponse.ofException(jsonException);
    }

    @ExceptionHandler(value = PageException.class)
    public ModelAndView pageException(PageException pageException) {

        log.info("[PageException]====>{},{}", pageException.getCode(), pageException.getMessage());
        ModelAndView view = new ModelAndView();
        view.addObject("message", pageException.getMessage());
        view.setViewName(DEFAULT_ERROR_PAGE);
        return view;
    }
}
