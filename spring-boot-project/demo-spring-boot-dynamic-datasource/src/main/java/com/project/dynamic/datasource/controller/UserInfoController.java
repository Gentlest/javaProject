package com.project.dynamic.datasource.controller;


import com.project.dynamic.datasource.annotation.DataSource;
import com.project.dynamic.datasource.constant.DatasourceType;
import com.project.dynamic.datasource.entity.mysql.UserInfo;
import com.project.dynamic.datasource.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Gentlest
 * @Description 合同信息Controller
 * @Date 2021/2/27 15:57
 */
@RestController
public class UserInfoController {

    private final UserInfoMapper userInfoMapper;

    @Autowired
    public UserInfoController(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    @GetMapping(value = "/userInfo")
    @DataSource(DatasourceType.MYSQL)
    public List<UserInfo> getUserInfo() {
        return userInfoMapper.findAll();
    }
}
