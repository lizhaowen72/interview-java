package com.lzw.java.concurrent.practice.lession032;

/**
 * @Auther: lizhaowen
 * @Date: 2020/7/4 11:45
 * @Description: Balking模式有一个非常典型的应用场景就是单词初始化
 */
public class InitTest {
    boolean inited = false;
    synchronized void init(){
        if (inited){
            return;
        }
        doInit();
        inited = true;
    }

    private void doInit() {
    }
}
