package com.springboot.study.util.mail;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright © 2018 宫宇祁. All rights reserved.
 * <p>
 * ${DESCRIPTION}
 *
 * @create 2018-01-16 10:29
 * @author: 宫宇祁
 * @ModificationHistory Who     When      What
 */
@Data
public class MailEntity implements Serializable {
    //此处填写smtp服务器
    private String smtpService;
    //设置端口号
    private String smtpPort;
    //设置发送邮箱
    private String fromMailAddress;
    //设置发送邮箱的smtp口令
    private String fromMailStmpPwd;
    //设置邮件标题
    private String title;
    //设置邮件内容
    private String content;
    //设置内容格式（默认html）
    private String contentType;
    //接收邮件地址集合
    private List<String> list = new ArrayList<>();
}
