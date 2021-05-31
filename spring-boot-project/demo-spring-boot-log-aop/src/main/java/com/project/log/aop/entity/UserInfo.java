package com.project.log.aop.entity;

import org.springframework.beans.factory.annotation.Value;

/**
 * @Author Gentlest
 * @Description
 * @Date 2021/2/24 17:15
 */
public class UserInfo {

    /**
     * 账号
     */
    @Value("admin")
    private String name;
    /**
     * 密码
     */
    @Value("123456")
    private String password;
}
