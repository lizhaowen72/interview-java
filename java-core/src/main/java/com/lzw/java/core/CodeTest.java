package com.lzw.java.core;

/**
 * @Auther: lizhaowen
 * @Date: 2020/9/3 15:33
 * @Description: TODO
 */
public class CodeTest {
    public static void main(String[] args) throws InterruptedException {
        final ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set(1);
                System.out.println(threadLocal.get());
            }
        },"t1");
        t1.start();

        t1.join();

        threadLocal.set(2);
        System.out.println(threadLocal.get());

        System.out.println(1);
    }
}
