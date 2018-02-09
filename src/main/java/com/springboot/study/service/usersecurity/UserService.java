package com.springboot.study.service.usersecurity;

import com.springboot.study.jpa.usersecurity.UserJpa;
import com.springboot.study.pojo.security.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Copyright © 2018 宫宇祁. All rights reserved.
 * <p>
 * ${DESCRIPTION}
 *
 * @create 2018-01-23 18:39
 * @author: 宫宇祁
 * @ModificationHistory Who     When      What
 */
public class UserService implements UserDetailsService {


    @Autowired
    UserJpa userSecurityJpa;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserEntity userEntity = userSecurityJpa.findByUsername(s);
        if (userEntity==null){
            throw new UsernameNotFoundException("未查询到用户:"+s+"信息");
        }
        return userEntity;
    }
}
