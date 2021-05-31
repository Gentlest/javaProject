package com.project.properties.controller;

import cn.hutool.core.lang.Dict;
import com.project.properties.property.ApplicationProperty;
import com.project.properties.property.DeveloperProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Gentlest
 * @Description 测试Controller
 * @Date 2021/2/24 12:38
 */
@RestController
public class PropertyController {

    private final ApplicationProperty applicationProperty;
    private final DeveloperProperty developerProperty;

    @Autowired
    public PropertyController(ApplicationProperty applicationProperty, DeveloperProperty developerProperty) {
        this.applicationProperty = applicationProperty;
        this.developerProperty = developerProperty;
    }

    @GetMapping("/property")
    public Dict index() {
        return Dict.create().set("ApplicationProperty", applicationProperty)
                .set("DeveloperProperty", developerProperty);
    }

}
