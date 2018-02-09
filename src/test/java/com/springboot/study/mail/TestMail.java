package com.springboot.study.mail;

import com.springboot.study.enums.mail.MailContentTypeEnum;
import com.springboot.study.util.mail.MailSender;
import org.junit.Test;

import java.util.Arrays;

/**
 * Copyright © 2018 宫宇祁. All rights reserved.
 * <p>
 * ${DESCRIPTION}
 *
 * @create 2018-01-16 10:40
 * @author: 宫宇祁
 * @ModificationHistory Who     When      What
 */
public class TestMail {
    @Test
    public void sendMailTest() throws Exception{
        new MailSender()
                .title("测试springboot发送邮件")
                .content("简单内容文本发送")
                .contentType(MailContentTypeEnum.TEXT)
                .targets(Arrays.asList("485849432@qq.com"))
                .send();

    }
}
