package com.springboot.study.config.filterlog;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.springboot.study.jpa.filterlog.LoggerJpa;
import com.springboot.study.pojo.logger.LoggerEntity;
import com.springboot.study.util.filterlog.LoggerUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.logging.Logger;

/**
 * Copyright © 2018 宫宇祁. All rights reserved.
 * <p>
 *自定义SpringMVC拦截器需要实现HandlerIntercptor接口
 *
 * @create 2018-01-08 18:13
 * @author: 宫宇祁
 * @ModificationHistory Who     When      What
 */
public class LoggerInterceptor implements HandlerInterceptor {

    //请求开始时间标识
    private static final String LOGGER_SEND_TIME = "send_time";
    //请求日志实体标识
    private static final String LOGGER_ENTITY = "logger_entity";
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //创建日志实体
        LoggerEntity logger = new LoggerEntity();
        //获取请求的sessionId
        String sessionId = httpServletRequest.getRequestedSessionId();
        //获取请求的路径
        String uri = httpServletRequest.getRequestURI();
        //获取请求参数信息
        String paramData = JSON.toJSONString(httpServletRequest.getParameterMap(), SerializerFeature.DisableCircularReferenceDetect,SerializerFeature.WriteMapNullValue);
        //设置客户端ip
        logger.setClientIp(LoggerUtils.getCliectIp(httpServletRequest));
        //设置请求方法
        logger.setMethod(httpServletRequest.getMethod());
        //设置请求类型（json|普通类型）
        logger.setType(LoggerUtils.getRequestType(httpServletRequest));
        //设置请求参数内容json字符串
        logger.setParamData(paramData);
        //设置请求地址
        logger.setUri(uri);
        //设置sessionId
        logger.setSessionId(sessionId);
        //设置请求开始时间
        httpServletRequest.setAttribute(LOGGER_SEND_TIME,System.currentTimeMillis());
        //设置请求实体到request内，方便afterCompletion方法调用
        httpServletRequest.setAttribute(LOGGER_ENTITY,logger);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        //获取请求错误码
        int status = httpServletResponse.getStatus();
        //当前时间
        long currentTime = System.currentTimeMillis();
        //请求开始时间
        long time = Long.valueOf(httpServletRequest.getAttribute(LOGGER_SEND_TIME).toString());
        //获取本次请求日志实体
        LoggerEntity loggerEntity = (LoggerEntity) httpServletRequest.getAttribute(LOGGER_ENTITY);
        //设置请求时间差
        loggerEntity.setTimeConsuming(Integer.valueOf(currentTime-time+""));
        //设置返回时间
        loggerEntity.setReturnTime(currentTime+"");
        //设置返回错误码
        loggerEntity.setHttpStatusCode(status+"");
        //设置返回码
        loggerEntity.setReturnData(JSON.toJSONString(httpServletRequest.getAttribute(LoggerUtils.LOGGER_RETURN),SerializerFeature.DisableCircularReferenceDetect,SerializerFeature.WriteMapNullValue));
        //执行将日志写入数据库
        LoggerJpa loggerDAO = getDao(LoggerJpa.class,httpServletRequest);
        loggerDAO.save(loggerEntity);
    }

    /**
     *根据传入的类型获取Spring管理对应的Dao
     * @param clazz 类型
     * @param request 请求对象
     * @param <T>
     * @return
     */
    private <T> T getDao(Class<T> clazz,HttpServletRequest request){
        BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        return factory.getBean(clazz);
    }
}
