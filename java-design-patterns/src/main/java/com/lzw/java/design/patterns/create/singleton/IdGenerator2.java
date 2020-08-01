package com.lzw.java.design.patterns.create.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Auther: lizhaowen
 * @Date: 2020/6/23 21:27
 * @Description: 懒汉式.支持延迟加载
 */
public class IdGenerator2 {
    private AtomicLong id = new AtomicLong(0);
    private static IdGenerator2 instance;

    private IdGenerator2() {

    }

    public static synchronized IdGenerator2 getInstance() {
        if (instance == null) {
            instance = new IdGenerator2();
        }
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
