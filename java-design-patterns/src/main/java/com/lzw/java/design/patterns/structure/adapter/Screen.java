package com.lzw.java.design.patterns.structure.adapter;

/**
 * @Auther: lizhaowen
 * @Date: 2020/8/2 17:14
 * @Description: TODO
 */
public class Screen {
    public static void main(String[] args) {
        Vga vga = new Typec2Vga1();
        vga.vgaInterface();

        System.out.println("-------------------");

        Phone phone = new Phone();
        Typec2Vga2 vga2 = new Typec2Vga2(phone);
        vga2.vgaInterface();
    }
}
