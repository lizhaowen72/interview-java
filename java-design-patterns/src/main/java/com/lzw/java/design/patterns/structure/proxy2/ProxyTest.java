package com.lzw.java.design.patterns.structure.proxy2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/**
 * @Auther: lizhaowen
 * @Date: 2020/7/11 16:55
 * @Description: TODO
 */
public class ProxyTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles",true);
        // 获取动态代理类
        Class<?> proxyClass = Proxy.getProxyClass(IHello.class.getClassLoader(), IHello.class);
        // 获取动态代理类的构造函数
        Constructor<?> constructor = proxyClass.getConstructor(InvocationHandler.class);
        // 通过构造函数来创建动态代理对象,将自定义的MyInvocationHandler实例传入
        IHello hello = (IHello) constructor.newInstance(new MyInvocationHandler(new Hello()));
        hello.sayHello();
    }
}
