//package com.springboot.study.config.security;
//
//import com.springboot.study.service.usersecurity.UserService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//
///**
// * Copyright © 2018 宫宇祁. All rights reserved.
// * <p>
// * ${DESCRIPTION}
// *
// * @create 2018-01-23 18:58
// * @author: 宫宇祁
// * @ModificationHistory Who     When      What
// */
//@Configuration
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    //完成实体自定义注入
//    @Bean
//    UserDetailsService userService(){
//        return new UserService();
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .anyRequest().authenticated()//所有请求必须登录后访问
//                .and()
//                    .formLogin()
//                    .loginPage("/login")
//                    .failureUrl("/login?error")
//                    .permitAll()//登录界面 错误界面可以直接访问
//                .and()
//                .logout()
//                .permitAll();//注销请求可以直接访问
//    }
//}
