package com.springboot.study.controller.validate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.springboot.study.pojo.validate.DemoEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

/**
 * Copyright © 2018 宫宇祁. All rights reserved.
 * <p>
 * ${DESCRIPTION}
 *
 * @create 2018-01-16 19:21
 * @author: 宫宇祁
 * @ModificationHistory Who     When      What
 */
@RestController
@RequestMapping(value = "/validator")
public class ValidatorController {
    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/validator",method = RequestMethod.GET)
    public String validator(@Valid DemoEntity demoEntity, BindingResult result){
        if (result.hasErrors()){
            StringBuffer msg = new StringBuffer();
            //获取错误字段集合
            List<FieldError> fieldErrors= result.getFieldErrors();
            //获取本地local zh_CN
            Locale currentLocale = LocaleContextHolder.getLocale();
            //遍历错误字段获取错误信息
            for (FieldError fieldError : fieldErrors) {
                //获取错误信息
                String errorMsg = messageSource.getMessage(fieldError,currentLocale);
                msg.append(fieldError.getField()+"  :   "+errorMsg);
            }
            return msg.toString();
        }
        return "验证通过 ,"+"名称 :"+demoEntity.getName()+"年龄: "+demoEntity.getAge()+" 邮箱地址："+demoEntity.getMail();
    }
}
