package com.project.mybatis.plus.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 全局转换前台日期
 *
 * @Author Gentlest
 * @Date 2021/3/29 11:33
 */
public class BaseController {

    @InitBinder
    public void initBinder(ServletRequestDataBinder binder) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(formatter, true));
    }
}
