package com.project.dynamic.datasource.mapper;

import com.project.dynamic.datasource.annotation.DataSource;
import com.project.dynamic.datasource.constant.DatasourceType;
import com.project.dynamic.datasource.entity.mysql.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Gentlest
 */
@Repository
@DataSource(DatasourceType.MYSQL)
public interface UserInfoMapper extends JpaRepository<UserInfo, Long> {
}
