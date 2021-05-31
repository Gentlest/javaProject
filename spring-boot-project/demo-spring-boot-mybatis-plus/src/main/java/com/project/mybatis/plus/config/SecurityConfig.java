package com.project.mybatis.plus.config;

import com.project.mybatis.plus.service.impl.UserServiceImpl;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;

/**
 * @Author Gentlest
 * @Date 2021/3/25 14:03
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private UserServiceImpl userService;

    /**
     * 请求授权认证
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 访问权限
        http.authorizeRequests()
                //.antMatchers("/index").permitAll()
                .antMatchers("/toLogin").permitAll()
                .antMatchers("/*").authenticated();

        //登录配置
        http.formLogin().usernameParameter("username").passwordParameter("password").loginPage("/toLogin")
                //登陆表单提交请求
                .loginProcessingUrl("/login")
                //登陆成功跳转页面
                .defaultSuccessUrl("/index");

        // 注销配置
        http.headers().contentTypeOptions().disable();
        http.headers().frameOptions().disable(); // 图片跨域
        http.csrf().disable();// 关闭csrf功能:跨站请求伪造,默认只能通过post方式提交logout请求
        http.logout().logoutSuccessUrl("/");

        // 记住我配置
        http.rememberMe().rememberMeParameter("remember");
    }

    /**
     * 用户授权验证
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                return DigestUtils.md5DigestAsHex(rawPassword.toString().getBytes());
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return encodedPassword.equals(DigestUtils.md5DigestAsHex(rawPassword.toString().getBytes()));
            }
        });
    }

}
