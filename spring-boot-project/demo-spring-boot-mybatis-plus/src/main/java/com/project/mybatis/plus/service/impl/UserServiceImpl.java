package com.project.mybatis.plus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.mybatis.plus.entity.UserInfo;
import com.project.mybatis.plus.mapper.UserMapper;
import com.project.mybatis.plus.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @Author Gentlest
 * @Date 2021/3/25 15:08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserInfo> implements UserService, UserDetailsService {

    @Resource
    UserService userService;

    @Resource
    HttpSession session;

    /**
     * 用户登陆验证
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 通过用户名查询用户
        UserInfo user = userService.getOne(new QueryWrapper<UserInfo>().eq("dlmc", username));
        // 放入session
        session.setAttribute("loginUser", user);

        //创建一个新的UserDetails对象，最后验证登陆的需要
        UserDetails userDetails = null;
        if (user != null) {
            String password = user.getPassword();
            //创建一个集合来存放权限
            Collection<GrantedAuthority> authorities = getAuthorities(user);
            //实例化UserDetails对象
            userDetails = new User(username, password,
                    true, true,
                    true, true, authorities);

        }
        return userDetails;
    }

    /**
     * 获取角色信息
     */
    private Collection<GrantedAuthority> getAuthorities(UserInfo userInfo) {
        ArrayList<GrantedAuthority> authList = new ArrayList<>();
        UserInfo id = userService.getById(1);  //模拟测试,实际为Role_ID
        //注意：这里每个权限前面都要加ROLE_。否在最后验证不会通过
        authList.add(new SimpleGrantedAuthority("ROLE_" + id.getUsername()));
        return authList;
    }
}
