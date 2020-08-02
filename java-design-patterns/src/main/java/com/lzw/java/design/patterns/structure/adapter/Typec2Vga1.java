package com.lzw.java.design.patterns.structure.adapter;

/**
 * @Auther: lizhaowen
 * @Date: 2020/8/2 16:24
 * @Description: TODO
 */
public class Typec2Vga1 extends Phone implements Vga{
    @Override
    public void vgaInterface() {
        typecPhone();
        System.out.println("接收到type-c口信息,信心转换成vga接口中...");
        System.out.println("信心已转换成vga接口,显示屏可以对接");
    }
}
