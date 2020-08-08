package com.lzw.java.design.patterns.behavior.template;

/**
 * @Auther: lizhaowen
 * @Date: 2020/8/8 09:35
 * @Description: TODO
 */
public class Demo {
    public static void main(String[] args) {
        AbstractClass concreteClass1 = new ConcreteClass1();
        concreteClass1.templateMethod();
    }
}
