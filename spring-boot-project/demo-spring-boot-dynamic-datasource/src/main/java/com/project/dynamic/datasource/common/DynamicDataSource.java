package com.project.dynamic.datasource.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Author Gentlest
 * @Date 2021/3/2 14:01
 */
@Slf4j
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {

        log.info("DynamicDataSources数据源====>{}", DynamicDataSourceContextHolder.getDatasourceType());
        return DynamicDataSourceContextHolder.getDatasourceType();
    }
}
