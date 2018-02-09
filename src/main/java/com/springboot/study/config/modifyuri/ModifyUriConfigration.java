package com.springboot.study.config.modifyuri;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Copyright © 2018 宫宇祁. All rights reserved.
 * <p>
 * ${DESCRIPTION}
 *
 * @create 2018-01-16 18:55
 * @author: 宫宇祁
 * @ModificationHistory Who     When      What
 */
@Configuration
public class ModifyUriConfigration extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/com/springboot/study/resources/**").addResourceLocations("classPath:/static/");
    }
}
