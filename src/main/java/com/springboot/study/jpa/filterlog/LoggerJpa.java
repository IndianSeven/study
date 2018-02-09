package com.springboot.study.jpa.filterlog;

import com.springboot.study.pojo.logger.LoggerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * Copyright © 2018 宫宇祁. All rights reserved.
 * <p>
 *  请求日志数据接口
 *JpaRepository接口包含了SpringDataJPA内的常用到的CRUD方法
 *
 * @create 2018-01-16 18:35
 * @author: 宫宇祁
 * @ModificationHistory Who     When      What
 */
public interface LoggerJpa extends JpaRepository<LoggerEntity,Integer>,Serializable {
}

