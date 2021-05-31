package com.project.template.thymeleaf.controller;

import com.project.template.thymeleaf.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @Author Gentlest
 * @Description
 * @Date 2021/2/25 14:17
 */
@Controller
@Slf4j
public class IndexController {

    @GetMapping(value ={ "/",""})
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView view = new ModelAndView();

        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("user");

        if (Objects.isNull(userInfo)) {
            view.setViewName("redirect:/user/login");
        } else {
            view.setViewName("page/index");
            view.addObject(userInfo);
        }
        return view;
    }
}
