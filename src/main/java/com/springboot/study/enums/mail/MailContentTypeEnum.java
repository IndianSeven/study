package com.springboot.study.enums.mail;

/**
 * Copyright © 2018 宫宇祁. All rights reserved.
 * <p>
 * 邮件得枚举
 *
 * @create 2018-01-16 10:39
 * @author: 宫宇祁
 * @ModificationHistory Who     When      What
 */
public enum MailContentTypeEnum {

    HTML("text/html;charset=UTF-8"),
    TEXT("text")
    ;
    private String value;

    MailContentTypeEnum(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
