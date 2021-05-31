package com.project.mybatis.plus.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author Gentlest
 * @Date 2021/3/24 15:55
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    /**
     * 配置日期格式化
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));
    }
}
