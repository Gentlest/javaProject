package com.project.properties.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author Gentlest
 * @Description 实体类
 * @Date 2021/2/24 12:36
 */
@Data
@Component
@ConfigurationProperties(prefix = "developer")
public class DeveloperProperty {

    private String name;
    private String qq;
}
