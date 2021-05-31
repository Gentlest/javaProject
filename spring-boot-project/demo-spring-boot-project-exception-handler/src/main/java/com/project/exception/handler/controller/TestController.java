package com.project.exception.handler.controller;

import com.project.exception.handler.api.ApiResponse;
import com.project.exception.handler.constant.StatusEnum;
import com.project.exception.handler.exception.JsonException;
import com.project.exception.handler.exception.PageException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author Gentlest
 * @Description
 * @Date 2021/2/25 13:37
 */
@Controller
public class TestController {

    @GetMapping("/json")
    @ResponseBody
    public ApiResponse jsonException() {
        throw new JsonException(StatusEnum.UNKNOWN_ERROR);
    }

    @GetMapping("/page")
    public ModelAndView pageException() {
        throw new PageException(StatusEnum.UNKNOWN_ERROR);
    }
}
