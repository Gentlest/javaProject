package com.project.jpa.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * @Author Gentlest
 * @Description Jpa配置类
 * @Date 2021/2/27 19:25
 */
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.project.jpa.dao"},
        transactionManagerRef = "jpaTransactionManager",
        entityManagerFactoryRef = "jpaEntityManagerFactory")
@Configuration
public class JpaConfig {


    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "jpaEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean jpaEntityManagerFactory() {
        // 配置jpa厂商适配器
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setShowSql(true);
        jpaVendorAdapter.setDatabase(Database.ORACLE);
        jpaVendorAdapter.setGenerateDdl(false);
        // 配置实体管理器工厂
        LocalContainerEntityManagerFactoryBean emfs =
                new LocalContainerEntityManagerFactoryBean();
        emfs.setJpaVendorAdapter(jpaVendorAdapter);
        emfs.setDataSource(dataSource());
        emfs.setPackagesToScan("com.project.jpa.entity");
        return emfs;
    }

    @Bean
    public PlatformTransactionManager jpaTransactionManager(EntityManagerFactory emf) {
        //配置jpa事务管理器
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

}
