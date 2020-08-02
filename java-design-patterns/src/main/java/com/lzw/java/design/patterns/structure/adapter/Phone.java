package com.lzw.java.design.patterns.structure.adapter;

/**
 * @Auther: lizhaowen
 * @Date: 2020/8/2 16:23
 * @Description: 定义一个手机Phone，它有一个Typec接口。
 */
public class Phone {
    public void typecPhone() {
        System.out.println("信息从Typec口的手机输出。");
    }
}
