package com.lzw.java.design.patterns.structure.proxy3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Auther: lizhaowen
 * @Date: 2020/9/2 10:08
 * @Description: TODO
 */
public class Demo3 {
    public static void main(String[] args) {
        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        ByeInterface bye = new Bye();
        InvocationHandler handler = new ProxyHandler(bye);
        ByeInterface byeProxy = (ByeInterface) Proxy.newProxyInstance(bye.getClass().getClassLoader(),bye.getClass().getInterfaces(),handler);
        byeProxy.sayBye();
    }
}
