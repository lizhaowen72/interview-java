package com.lzw.java.concurrent.practice.lession001;

/**
 * @Auther: lizhaowen
 * @Date: 2020/6/4 22:01
 * @Description: 程序的顺序性原则
 */
public class VolatileExample {
    int x=0;
    volatile boolean v = false;
    public void writer(){
        x=42;
        v=true;
    }
    public void reader(){
        if (v==true){
            // 这里x会是多少呢?
        }
    }

    public static void main(String[] args) {
    }
}
