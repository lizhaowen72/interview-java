package com.lzw.java.design.patterns.structure.proxy3;

/**
 * @Auther: lizhaowen
 * @Date: 2020/9/2 09:57
 * @Description: TODO
 */
public class HelloProxy implements HelloInterface{
    private HelloInterface hello = new Hello();
    @Override
    public void sayHello() {
        System.out.println("before invoke sayHello");
        hello.sayHello();
        System.out.println("after invoke sayHello");
    }
}
