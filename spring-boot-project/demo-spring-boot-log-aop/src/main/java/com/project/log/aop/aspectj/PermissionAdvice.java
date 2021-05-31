package com.project.log.aop.aspectj;

import com.project.log.aop.annotation.PermissionAccess;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @Author Gentlest
 * @Description 通过Aop实现权限校验
 * @Date 2021/2/24 16:45
 */
@Aspect
@Slf4j
@Component
public class PermissionAdvice {
    /**
     * 切入点
     */
    @Pointcut("@annotation(com.project.log.aop.annotation.PermissionAccess)")
    public void permissionCheck() { // 切点
    }

    /**
     * 前置方法
     *
     * @param joinPoint 切入点
     */
    @Before("permissionCheck()")
    public void beforePermissionCheck(JoinPoint joinPoint) {

        log.info(joinPoint.getSignature().getName());

        //获取传入目标方法的参数
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            log.info("第{}个方法的参数为{}", i + 1, args[i]);
        }
    }

    /**
     * 环绕操作
     *
     * @param joinPoint 切入点
     * @return 返回原方法
     * @throws Throwable 异常
     */
    @Around("permissionCheck()")
    public Object aroundPermissionCheck(ProceedingJoinPoint joinPoint) throws Throwable {

        //获取切入点方法签名
        MethodSignature method = (MethodSignature) joinPoint.getSignature();
        PermissionAccess permissionAccess = method.getMethod().getAnnotation(PermissionAccess.class);

        log.info(String.valueOf(permissionAccess.value()));

        // 校验访问权限
        if ("view".equals(permissionAccess.value())) {
            return null;
        }
        return joinPoint.proceed();
    }
}
