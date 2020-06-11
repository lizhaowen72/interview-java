package com.lzw.java.concurrent.practice.lession001;

/**
 * @Auther: lizhaowen
 * @Date: 2020/6/6 10:33
 * @Description: TODO
 */
public class VolatileSingleton {

    private volatile VolatileSingleton instance;

    private VolatileSingleton(){

    }

    public VolatileSingleton getInstance(){
        if (instance == null){
            synchronized (VolatileSingleton.class){
                if (instance == null){
                    instance = new VolatileSingleton();
                }
            }
        }
        return instance;
    }
}
