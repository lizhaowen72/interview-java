package com.lzw.java.design.patterns.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Auther: lizhaowen
 * @Date: 2020/6/23 21:19
 * @Description: 饿汉式单例模式.在类加载的时候,instance静态实例就已经创建并初始化好了.
 * 所以,instance实例的创建过程是线程安全的.不过这样的实现方式不支持延迟加载
 */
public class IdGenerator {
    private AtomicLong id = new AtomicLong(0);
    private static final IdGenerator instance = new IdGenerator();

    private IdGenerator() {

    }
    public static IdGenerator getInstance(){
        return instance;
    }
    public long getId(){
        return id.incrementAndGet();
    }
}
