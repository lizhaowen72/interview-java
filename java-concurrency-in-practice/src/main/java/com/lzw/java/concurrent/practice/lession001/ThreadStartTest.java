package com.lzw.java.concurrent.practice.lession001;

/**
 * @Auther: lizhaowen
 * @Date: 2020/6/4 22:10
 * @Description: 线程start()规则
 */
public class ThreadStartTest {
    static int var = 0;

    public static void main(String[] args) {
        Thread b = new Thread(() -> {
            // main线程调用b.start()之前,所有对共享变量的修改,此处皆可见
            System.out.println(var);
        });
        // 此处对共享变量var修改
        var = 77;
        // 主线程启动子线程
        b.start();
    }
}
