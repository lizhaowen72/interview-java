package com.lzw.java.design.patterns.structure.adapter;

/**
 * @Auther: lizhaowen
 * @Date: 2020/8/2 16:12
 * @Description: 适配器
 */
public class Adaptor extends Adaptee implements ITarget{
    @Override
    public void f1() {
        System.out.println("f1()");
    }

    @Override
    public void f2() {
        System.out.println("f2()");
    }
}
