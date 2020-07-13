package com.lzw.java.concurrent.practice.lession032;

/**
 * @Auther: lizhaowen
 * @Date: 2020/7/4 11:53
 * @Description: TODO
 */
public class DCSingleton {
    private static volatile DCSingleton singleton;

    private DCSingleton() {
    }
    public static DCSingleton getInstance(){
        if (singleton==null){
            synchronized (DCSingleton.class){
                if (singleton==null){
                    singleton = new DCSingleton();
                }
            }
        }
        return singleton;
    }
}
