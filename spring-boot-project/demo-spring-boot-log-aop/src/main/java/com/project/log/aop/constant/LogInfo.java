package com.project.log.aop.constant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Gentlest
 * @Description 日志内容
 * @date 2021/2/24 14:10
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LogInfo {
    /**
     * IP地址
     */
    private String ip;
    /**
     * url
     */
    private String url;

    /**
     * 请求方法
     */
    private String httpMethod;
    /**
     * UserAgent
     */
    private String userAgent;
    /**
     * 操作系统
     */
    private String os;
    /**
     * 浏览器
     */
    private String browser;
    /**
     * 类方法
     */
    private String classMethod;
    /**
     * 请求参数
     */
    private Object requestParams;
    /**
     * 返回参数
     */
    private Object responseParams;
    /**
     * 接口耗时
     */
    private Long timeConstant;
    /**
     * 线程ID
     */
    private String threadId;
    /**
     * 线程名称
     */
    private String threadName;


}
