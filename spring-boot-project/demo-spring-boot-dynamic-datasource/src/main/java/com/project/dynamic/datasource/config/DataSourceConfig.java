package com.project.dynamic.datasource.config;

import com.project.dynamic.datasource.common.DynamicDataSource;
import com.project.dynamic.datasource.constant.DatasourceType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;

/**
 * 数据源配置
 *
 * @Author Gentlest
 * @Date 2021/3/2 14:01
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.project.dynamic.datasource.mapper",
        entityManagerFactoryRef = "dynamicEntityManagerFactory",
        transactionManagerRef = "dynamicTransactionManager")
public class DataSourceConfig {

    @Bean
    @Qualifier(value = "oracleDataSource")
    @ConfigurationProperties(value = "spring.datasource.oracle")
    public DataSource oracleDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Qualifier(value = "mysqlDataSource")
    @ConfigurationProperties(value = "spring.datasource.mysql")
    public DataSource mysqlDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "dynamicDataSource")
    public DynamicDataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        //配置默认数据源
        dynamicDataSource.setDefaultTargetDataSource(oracleDataSource());
        //配置多数据源
        HashMap<Object, Object> dataSourceMap = new HashMap<>(5);

        dataSourceMap.put(DatasourceType.ORACLE.name(), oracleDataSource());
        dataSourceMap.put(DatasourceType.MYSQL.name(), mysqlDataSource());
        dynamicDataSource.setTargetDataSources(dataSourceMap);
        return dynamicDataSource;
    }

    @Primary
    @Bean(name = "dynamicEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        // 实体工厂配置
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(Database.ORACLE);
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setDataSource(dynamicDataSource());
        factory.setPackagesToScan("com.project.dynamic.datasource.entity.*");
        return factory;
    }

    @Primary
    @Bean(name = "dynamicTransactionManager")
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager manager = new JpaTransactionManager();
        manager.setEntityManagerFactory(entityManagerFactory);
        return manager;
    }
}
