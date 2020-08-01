package com.lzw.java.design.patterns.structure.proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Auther: lizhaowen
 * @Date: 2020/7/11 16:52
 * @Description: TODO
 */
public class MyInvocationHandler implements InvocationHandler {
    // 目标对象
    private Object proxiedObject;

    public MyInvocationHandler(Object proxiedObject) {
        this.proxiedObject = proxiedObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("----------插入前通知代码-----------");
        Object result = method.invoke(proxiedObject, args);
        System.out.println("--------------插入后通知代码-------");
        return result;
    }
}
