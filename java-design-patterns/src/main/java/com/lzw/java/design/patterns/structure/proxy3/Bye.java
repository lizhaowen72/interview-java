package com.lzw.java.design.patterns.structure.proxy3;

/**
 * @Auther: lizhaowen
 * @Date: 2020/9/2 10:07
 * @Description: TODO
 */
public class Bye implements ByeInterface {
    @Override
    public void sayBye() {
        System.out.println("Bye xiaomian");
    }
}
