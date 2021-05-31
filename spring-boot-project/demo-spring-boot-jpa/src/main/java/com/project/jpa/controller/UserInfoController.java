package com.project.jpa.controller;

import com.project.jpa.dao.UserInfoMapper;
import com.project.jpa.entity.UserInfo;
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
    public List<UserInfo> getContractInfo() {
        return userInfoMapper.findAll();
    }
}
