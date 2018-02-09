package com.springboot.study.service.user;

import com.springboot.study.jpa.user.TUserJPA;
import com.springboot.study.pojo.user.TUserEntity;
import com.springboot.study.service.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright © 2018 宫宇祁. All rights reserved.
 * <p>
 * ${DESCRIPTION}
 *
 * @create 2018-01-16 10:15
 * @author: 宫宇祁
 * @ModificationHistory Who     When      What
 */
@Service
@CacheConfig(cacheNames = "user" )
public class TUserService {

    @Autowired
    private TUserJPA tUserJPA;

    @Autowired
    private RedisService redisService;

    /**
     * 查询用户列表方法
     * @return
     */
    @Cacheable
    public List<TUserEntity> list(){
        return tUserJPA.findAll();
    }

    public TUserEntity findById(Long id){
        String key = "user:"+id;//redis key
        TUserEntity userEntity =  (TUserEntity)redisService.get(key);
        if (userEntity==null){
            userEntity =  tUserJPA.findOne(id);
            redisService.set(key,userEntity,3600*24);
        }
        return userEntity;

    }
    /**
     * 添加、更新用户方法
     * @param entity
     * @return
     */
    public TUserEntity save(TUserEntity entity)
    {
        return tUserJPA.save(entity);
    }

    /**
     * 删除用户方法
     * @param id 用户编号
     * @return
     */
    public List<TUserEntity> delete(Long id)
    {
        tUserJPA.delete(id);
        return tUserJPA.findAll();
    }
}
