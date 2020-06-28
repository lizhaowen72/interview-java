package com.lzw.java.concurrent.practice.lession016;

import java.util.Queue;

/**
 * @Auther: lizhaowen
 * @Date: 2020/6/15 22:48
 * @Description: TODO
 */
public class Semaphore {
    // 计数器
    int count;
    // 等待队列
    Queue queue;
    // 初始化操作
    public Semaphore(int c){
        this.count = c;
    }
    void down(){
        this.count--;
        if (this.count<0){
            // 将当前线程插入等待队列
            // 阻塞当前线程
        }
    }
    void up(){
        this.count++;
        if (this.count<=0){
            // 移除等待队列中的某个线程
            // 唤醒线程
        }
    }

    public void acquire() {
        down();
    }

    public void release() {
        up();
    }
}
