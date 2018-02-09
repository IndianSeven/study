package com.springboot.study.controller.filter;

import com.alibaba.fastjson.JSONObject;
import com.springboot.study.util.filterlog.LoggerUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Copyright © 2018 宫宇祁. All rights reserved.
 * <p>
 * ${DESCRIPTION}
 *
 * @create 2018-01-16 18:42
 * @author: 宫宇祁
 * @ModificationHistory Who     When      What
 */
@RestController
@RequestMapping(value = "/filter",produces = "application/json")
public class FilterLoggerController {
    /**
     * 简单测试请求日志记录
     * @param request 请求对象
     * @param name 用户名
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public JSONObject login(HttpServletRequest request, String name) throws Exception
    {
        JSONObject obj = new JSONObject();
        obj.put("msg","用户："+name+",登录成功。");
        //将返回值写入到请求对象中
        System.out.println(obj.toJSONString());
        request.setAttribute(LoggerUtils.LOGGER_RETURN,obj);
        return obj;
    }
}
