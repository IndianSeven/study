package com.springboot.study.jpa.usersecurity;

import com.springboot.study.pojo.security.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Copyright © 2018 宫宇祁. All rights reserved.
 * <p>
 * ${DESCRIPTION}
 *
 * @create 2018-01-23 18:36
 * @author: 宫宇祁
 * @ModificationHistory Who     When      What
 */
public interface UserJpa extends JpaRepository<UserEntity,Long> {
    //使用SpringDataJpa定义查询
    public UserEntity findByUsername(String username);

//    @Query("SELECT u from UserEntity u where u.username =:username")
//    public UserEntity findByUsername(@Param("username") String username);
}
