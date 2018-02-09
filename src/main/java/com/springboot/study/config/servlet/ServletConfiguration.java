package com.springboot.study.config.servlet;

import com.springboot.study.servlet.TestServlet;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Copyright © 2018 宫宇祁. All rights reserved.
 * <p>
 * ${DESCRIPTION}
 *
 * @create 2018-01-16 11:04
 * @author: 宫宇祁
 * @ModificationHistory Who     When      What
 */
@Configuration
public class ServletConfiguration {

//    @Bean
//    public ServletRegistrationBean servletRegistrationBean(){
//        return new ServletRegistrationBean(new TestServlet(),"/test");
//    }
}
