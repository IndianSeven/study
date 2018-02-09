package com.springboot.study.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Copyright © 2018 宫宇祁. All rights reserved.
 * <p>
 * ${DESCRIPTION}
 *
 * @create 2018-01-16 19:19
 * @author: 宫宇祁
 * @ModificationHistory Who     When      What
 */
public class FlagValidatorClass implements ConstraintValidator<FlagValidator,Object> {
    //临时变量保存flag值列表
    private String values;

    //初始化value值
    @Override
    public void initialize(FlagValidator flagValidator) {
        //将注解内配置的值复制给临时变量
        this.values = flagValidator.values();
    }


    //实现验证
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        String[] value_array = values.split(",");
        boolean isFlag = false;
        //遍历对比有效值
        for (String s : value_array) {
            //存在一致跳出循环，赋值isFlag= true;
            if (s.equals(value)){
                isFlag = true;
                break;
            }
        }
        return isFlag;
    }
}
