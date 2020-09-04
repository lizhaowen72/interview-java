package com.lzw.java.design.patterns.structure.proxy3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Auther: lizhaowen
 * @Date: 2020/9/2 10:02
 * @Description: TODO
 */
public class Demo2 {
    public static void main(String[] args) {
        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        HelloInterface hello = new Hello();
        InvocationHandler handler = new ProxyHandler(hello);
        HelloInterface proxyHello = (HelloInterface) Proxy.newProxyInstance(hello.getClass().getClassLoader(), hello.getClass().getInterfaces(), handler);
        proxyHello.sayHello();
    }
}
