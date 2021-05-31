package com.project.dynamic.datasource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * The type Dynamic datasource application.
 *
 * @Author Gentlest
 * @Date 2021 /3/2 13:11
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class DynamicDatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamicDatasourceApplication.class, args);
    }
}
