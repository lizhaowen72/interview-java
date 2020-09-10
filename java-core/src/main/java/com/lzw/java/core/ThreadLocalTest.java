package com.lzw.java.core;

/**
 * @Auther: lizhaowen
 * @Date: 2020/9/3 16:30
 * @Description: TODO
 */
public class ThreadLocalTest {
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    private static ThreadLocal<Integer> threadLocal2 = new ThreadLocal<>();
    public static void main(String[] args) {

        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    threadLocal.set(i);
                    threadLocal.set(i+100);
                    System.out.println(Thread.currentThread().getName() + "====" + threadLocal.get());
                    System.out.println(Thread.currentThread().getName() + "====" + threadLocal.get());;
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                threadLocal.remove();
            }
        }, "threadLocal1").start();


//        new Thread(() -> {
//            try {
//                for (int i = 0; i < 10; i++) {
//                    threadLocal.set(i);
//                    System.out.println(Thread.currentThread().getName() + "====" + threadLocal.get());
//                    try {
//                        Thread.sleep(200);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            } finally {
//                threadLocal.remove();
//            }
//        }, "threadLocal2").start();
    }
}


