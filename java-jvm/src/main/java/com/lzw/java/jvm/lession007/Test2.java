package com.lzw.java.jvm.lession007;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Auther: lizhaowen
 * @Date: 2020/6/11 21:03
 * @Description: TODO
 */
public class Test2 {
    public static void target(int i) {
        new Exception("#" + i).printStackTrace();
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> kClass = Class.forName("com.lzw.java.jvm.lession007.Test2");
        Method method = kClass.getMethod("target", int.class);
        for (int i = 0; i < 20; i++) {
            method.invoke(null, i);
        }
    }
}
