package com.project.dynamic.datasource.common;

import lombok.extern.slf4j.Slf4j;

/**
 * 多数据源上下文操作
 *
 * @Author Gentlest
 * @Date 2021/3/2 13:42
 */
@Slf4j
public class DynamicDataSourceContextHolder {

    private DynamicDataSourceContextHolder() { //防止被实例化
    }

    private static final ThreadLocal<String> DATASOURCE_HOLDER = new ThreadLocal<>();

    /**
     * 获取数据源
     *
     * @return 数据源名称
     */
    public static String getDatasourceType() {
        return DATASOURCE_HOLDER.get();
    }

    /**
     * 切换数据源
     *
     * @param datasourceType 数据源
     */
    public static void setDatasourceType( String datasourceType) {
        log.info("切换到{}数据源", datasourceType);
        DATASOURCE_HOLDER.set(datasourceType);
    }

    /**
     * 清空数据源
     */
    public static void clearDatasourceType() {
        DATASOURCE_HOLDER.remove();
    }

}
