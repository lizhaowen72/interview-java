package com.lzw.java.concurrent.practice.lession003;

/**
 * @Auther: lizhaowen
 * @Date: 2020/6/7 12:59
 * @Description: TODO
 */
public class SafeCalc {
    long value = 0L;
    long get(){
        synchronized (new Object()){
            return value;
        }
    }
    void addOne(){
        synchronized (new Object()){
            value+=1;
        }
    }
}
