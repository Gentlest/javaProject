package com.project.dynamic.datasource.annotation;

import com.project.dynamic.datasource.constant.DatasourceType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标识用户使用的数据源
 *
 * @Author Gentlest
 * @Date 2021/3/2 13:25
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface DataSource {
    /**
     * 切换的数据源名称,默认为Oracle
     */
    DatasourceType value() default DatasourceType.ORACLE;
}
