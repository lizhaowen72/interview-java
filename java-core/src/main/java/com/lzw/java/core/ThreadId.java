package com.lzw.java.core;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Auther: lizhaowen
 * @Date: 2020/9/3 13:06
 * @Description: TODO
 */
public class ThreadId {
    static final AtomicLong nextId = new AtomicLong(0);
    static final ThreadLocal<Long> tl = ThreadLocal.withInitial(() -> nextId.getAndIncrement());

    static long get() {
        return tl.get();
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(tl.get());
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(tl.get());
            }
        });
        t2.start();
    }
}
