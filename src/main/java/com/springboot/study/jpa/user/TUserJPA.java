package com.springboot.study.jpa.user;

import com.springboot.study.pojo.user.TUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * Copyright © 2018 宫宇祁. All rights reserved.
 * <p>
 * ${DESCRIPTION}
 *
 * @create 2018-01-16 10:15
 * @author: 宫宇祁
 * @ModificationHistory Who     When      What
 */
/*JpaRepository接口（SpringDataJPA提供的简单数据操作接口）、JpaSpecificationExecutor（SpringDataJPA提供的复杂查询接口）、Serializable（序列化接口）*/
//@EnableJpaRepositories(basePackages="com.example.bootandspringdatajpa.jpa", entityManagerFactoryRef="UserJPA")
public interface TUserJPA extends JpaRepository<TUserEntity,Long>,Serializable {
}
