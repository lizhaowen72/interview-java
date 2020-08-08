package com.lzw.java.design.patterns.behavior.template;

/**
 * @Auther: lizhaowen
 * @Date: 2020/8/8 09:32
 * @Description: TODO
 */
public abstract class AbstractClass {
    public final void templateMethod(){
        method0();
        method1();
        method2();
    }

    protected  void method0(){
        System.out.println("method0");
    }

    protected abstract void method1();
    protected abstract void method2();

}
