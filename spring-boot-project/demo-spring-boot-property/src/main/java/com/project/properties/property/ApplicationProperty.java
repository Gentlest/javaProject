package com.project.properties.property;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author Gentlest
 * @Description 实体类
 * @Date 2021/2/24 12:36
 */
@Data
@Component
public class ApplicationProperty {

    @Value("${application.name}")
    private String name;
    @Value("${application.version}")
    private String version;
    @Value("${application.fileName}")
    private String fileName;
}
