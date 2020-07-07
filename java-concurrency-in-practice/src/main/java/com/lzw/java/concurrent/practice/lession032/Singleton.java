package com.lzw.java.concurrent.practice.lession032;

/**
 * @Auther: lizhaowen
 * @Date: 2020/7/4 11:50
 * @Description: TODO
 */
public class Singleton {
    private static Singleton singleton;
    // 构造方法私有化
    private Singleton(){

    }
    // 获取单例
    public synchronized static Singleton getInstance(){
        if (singleton==null){
            singleton=new Singleton();
        }
        return singleton;
    }
}
