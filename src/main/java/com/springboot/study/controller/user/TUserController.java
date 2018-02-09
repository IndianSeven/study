package com.springboot.study.controller.user;

import com.springboot.study.pojo.user.TUserEntity;
import com.springboot.study.service.user.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Copyright © 2018 宫宇祁. All rights reserved.
 * <p>
 * ${DESCRIPTION}
 *
 * @create 2018-01-16 10:16
 * @author: 宫宇祁
 * @ModificationHistory Who     When      What
 */
@RestController
@RequestMapping(value = "/tuser",produces = "application/json")
public class TUserController {

    @Autowired
    private TUserService tUserService;

    /**
     * 查询用户列表
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<TUserEntity> list(){
        return tUserService.list();
    }

    @RequestMapping(value = "/findUserById",method = RequestMethod.GET)
    public TUserEntity findById(Long id){
        return tUserService.findById(id);
    }

    /**
     * 添加、更新用户方法
     * @param entity
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.GET)
    public TUserEntity save(TUserEntity entity)
    {
        return tUserService.save(entity);
    }

    /**
     * 删除用户方法
     * @param id 用户编号
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public List<TUserEntity> delete(Long id)
    {
        tUserService.delete(id);
        return tUserService.list();
    }
}
