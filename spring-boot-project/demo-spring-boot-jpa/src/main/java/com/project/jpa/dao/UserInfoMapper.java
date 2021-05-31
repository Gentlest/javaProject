package com.project.jpa.dao;

import com.project.jpa.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * @Author Gentlest
 * @Description
 * @Date 2021/2/27 15:44
 */
@Component
public interface UserInfoMapper extends JpaRepository<UserInfo, Long> {
}
