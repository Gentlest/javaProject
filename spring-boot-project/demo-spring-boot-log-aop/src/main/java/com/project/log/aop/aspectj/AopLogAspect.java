package com.project.log.aop.aspectj;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.google.common.collect.Maps;
import com.project.log.aop.constant.LogInfo;
import com.project.log.aop.utils.IpUtils;
import eu.bitwalker.useragentutils.UserAgent;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

/**
 * @Author Gentlest
 * @Description 使用aop切面记录请求日志
 * @Date 2021/2/24 14:02
 */
@Aspect
@Slf4j
@Component
public class AopLogAspect {

    @Pointcut("execution(* com.project.log.aop.controller.*Controller.*(..))")
    public void log() { //日志切面
    }

    @Around("log()")
    public Object aroundLog(ProceedingJoinPoint joinPoint) throws Throwable {

        //获取上下文请求信息
        ServletRequestAttributes attributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();

        long startTime = System.currentTimeMillis();
        String header = request.getHeader("User-Agent");
        UserAgent userAgent = UserAgent.parseUserAgentString(header);
        Object requestParams = joinPoint.proceed();

        LogInfo logInfo = LogInfo.builder()
                .ip(IpUtils.getIpAdd(request))
                .url(request.getRequestURI())
                .httpMethod(request.getMethod())
                .userAgent(header)
                .os(userAgent.getOperatingSystem().toString())
                .classMethod(StrUtil.format("{}.{}",
                        joinPoint.getSignature().getDeclaringTypeName(),
                        joinPoint.getSignature().getName()))
                .requestParams(getNameAndValue(joinPoint))
                .responseParams(requestParams)
                .timeConstant(System.currentTimeMillis() - startTime)
                .threadId(Long.toString(Thread.currentThread().getId()))
                .threadName(Thread.currentThread().getName())
                .build();

        log.info("请求信息--> {}", JSONUtil.toJsonStr(logInfo));

        return requestParams;
    }

    /**
     * 获取方法参数名和参数值
     *
     * @param joinPoint 切入点
     * @return 返回请求参数map
     */
    private Map<String, Object> getNameAndValue(ProceedingJoinPoint joinPoint) {

        final Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        final String[] names = methodSignature.getParameterNames();
        final Object[] args = joinPoint.getArgs();

        if (ArrayUtil.isEmpty(names) || ArrayUtil.isEmpty(args)) {
            return Collections.emptyMap();
        }
        if (names.length != args.length) {
            log.warn("{}方法参数名和参数值数量不一致", methodSignature.getName());
            return Collections.emptyMap();
        }
        Map<String, Object> map = Maps.newHashMap();
        for (int i = 0; i < names.length; i++) {
            map.put(names[i], args[i]);
        }
        return map;
    }

}
