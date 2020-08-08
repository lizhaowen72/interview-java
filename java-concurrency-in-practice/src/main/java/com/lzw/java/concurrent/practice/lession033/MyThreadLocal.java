package com.lzw.java.concurrent.practice.lession033;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: lizhaowen
 * @Date: 2020/8/7 13:31
 * @Description: TODO
 */
public class MyThreadLocal<T> {
    Map<Thread,T> locals = new ConcurrentHashMap<>();
    T get(){
        return locals.get(Thread.currentThread());
    }
    void set(T t){
        locals.put(Thread.currentThread(),t);
    }
}
