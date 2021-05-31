package com.project.mybatis.plus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * 登陆页面Controller
 *
 * @Author Gentlest
 * @Date 2021/3/24 19:39
 */
@Controller
public class LoginController {


    @GetMapping({"/", "/index"})
    public String index() {
        return "index";
    }


    @GetMapping("/toLogin")
    public String login(HttpSession session) {

        if (session.getAttribute("loginUser") != null) {
            return "redirect:/";
        } else {
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 删除session
        session.invalidate();
        return "redirect:/toLogin";
    }
}
