package com.project.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @Author Gentlest
 * @Description
 * @Date 2021/2/27 19:44
 */
@SpringBootApplication
public class JpaProjectApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(JpaProjectApplication.class, args);
    }
}
