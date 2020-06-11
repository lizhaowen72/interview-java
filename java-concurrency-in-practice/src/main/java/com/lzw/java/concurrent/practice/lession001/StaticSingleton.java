package com.lzw.java.concurrent.practice.lession001;

/**
 * @Auther: lizhaowen
 * @Date: 2020/6/6 10:39
 * @Description: TODO
 */
public class StaticSingleton {

    // 内部类
    private static class InnerSingleton{
        private static StaticSingleton instance = new StaticSingleton();
    }

    private StaticSingleton(){

    }

    public StaticSingleton getInstance(){
        return InnerSingleton.instance;
    }
}

