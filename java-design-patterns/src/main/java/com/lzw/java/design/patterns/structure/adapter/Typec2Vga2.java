package com.lzw.java.design.patterns.structure.adapter;

/**
 * @Auther: lizhaowen
 * @Date: 2020/8/2 17:17
 * @Description: TODO
 */
public class Typec2Vga2 implements Vga{
    private Phone phone;

    public Typec2Vga2(Phone phone) {
        this.phone = phone;
    }

    @Override
    public void vgaInterface() {
        if (phone!=null){
            phone.typecPhone();
            System.out.println("接收到type-c口信息,信息转换成vga接口中");
            System.out.println("信息已经转换成vga接口,显示屏可以对接");
        }
    }
}
