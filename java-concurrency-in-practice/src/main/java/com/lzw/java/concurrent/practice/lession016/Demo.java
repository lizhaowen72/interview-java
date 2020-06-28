package com.lzw.java.concurrent.practice.lession016;

import com.lzw.java.concurrent.practice.lession016.Semaphore;

/**
 * @Auther: lizhaowen
 * @Date: 2020/6/15 22:57
 * @Description: TODO
 */
public class Demo {
    static int count;
    // 初始化信号量
    static final Semaphore s = new Semaphore(1);
    // 用信号量保证互斥
    static void addOne(){
        s.acquire();
        try {
            count+=1;
        }finally {
            s.release();
        }
    }
}
