package com.lzw.java.concurrent.practice.lession033;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Auther: lizhaowen
 * @Date: 2020/8/7 13:16
 * @Description: TODO
 */
public  class Demo {
    static class ThreadId{
        static final AtomicLong nextId = new AtomicLong(0);
        static final ThreadLocal<Long> tl = ThreadLocal.withInitial(()->nextId.getAndIncrement());
        static long get(){
            return tl.get();
        }
    }

    public static void main(String[] args) {
       new Thread(new Runnable() {
           @Override
           public void run() {
               long l = ThreadId.get();
               System.out.println(l);
               long l1 = ThreadId.get();
               System.out.println(l1);
           }
       }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                long l2 = ThreadId.get();
                System.out.println(l2);
                long l3 = ThreadId.get();
                System.out.println(l3);
            }
        }).start();
    }
}

