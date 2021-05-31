package com.project.dynamic.datasource.aspactj;

import com.project.dynamic.datasource.annotation.DataSource;
import com.project.dynamic.datasource.common.DynamicDataSourceContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * AOP实现数据源切换
 *
 * @author Gentlest
 * @Date 2021/3/2 15:26
 */
@Slf4j
@Aspect
@Component
public class DynamicDataSourceAspect {

    @Pointcut("execution( * com.project.dynamic.datasource.controller.*.* (..))")
    public void dynamicDataSource() { // 切入点
    }

    @Before("dynamicDataSource()")
    public void beforeDynamicDataSource(JoinPoint joinPoint) {

        MethodSignature method = (MethodSignature) joinPoint.getSignature();
        DataSource dataSourceAnnotation = method.getMethod().getAnnotation(DataSource.class);
        if (method.getMethod().isAnnotationPresent(DataSource.class)) {
            log.info("切入点数据源====>{}", dataSourceAnnotation.value().name());
            DynamicDataSourceContextHolder.setDatasourceType(dataSourceAnnotation.value().name());
        }
    }

    @After("dynamicDataSource()")
    public void afterDynamicDataSource(JoinPoint joinPoint) {
        MethodSignature method = (MethodSignature) joinPoint.getSignature();

        if (method.getMethod().isAnnotationPresent(DataSource.class)){
            // 销毁数据源 在执行方法之后
            log.info("销毁数据源=====>{}", DynamicDataSourceContextHolder.getDatasourceType());
            DynamicDataSourceContextHolder.clearDatasourceType();
        }
    }
}
