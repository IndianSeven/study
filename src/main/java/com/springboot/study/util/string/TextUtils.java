package com.springboot.study.util.string;

import java.util.List;

/**
 * Copyright © 2018 宫宇祁. All rights reserved.
 * <p>
 * ${DESCRIPTION}
 *
 * @create 2018-01-16 10:34
 * @author: 宫宇祁
 * @ModificationHistory Who     When      What
 */
public class TextUtils {
    /**
     * CharSequence是一个接口，String实现了这个接口
     * 我们可以用TextUtils.isEmpty（str）来代替if(text == null || text.length() == 0)。
     * @param str
     * @return
     */
    public static boolean isEmpty(CharSequence str) {
        return str == null || str.length() == 0;
    }

    /**
     * 判断集合是否为空
     * @param list
     * @return
     */
    public static boolean isEmpty(List<?> list) {
        return list==null||list.size()==0;
    }

}
