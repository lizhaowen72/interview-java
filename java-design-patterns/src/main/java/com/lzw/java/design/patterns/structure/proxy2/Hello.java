package com.lzw.java.design.patterns.structure.proxy2;

/**
 * @Auther: lizhaowen
 * @Date: 2020/7/11 16:51
 * @Description: TODO
 */
public class Hello implements IHello{
    @Override
    public void sayHello() {
        System.out.println("hello world");
    }
}
