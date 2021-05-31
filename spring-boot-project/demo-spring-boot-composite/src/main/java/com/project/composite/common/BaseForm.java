package com.project.composite.common;

/**
 * 抽象表单用于实体类与展示层数据转换
 *
 * @Author Gentlest
 * @Date 2021/3/5 13:39
 */
public interface BaseForm<T> {
    /**
     * 获取实例
     *
     * @return 返回实体类
     */
    T buildEntity();
}
