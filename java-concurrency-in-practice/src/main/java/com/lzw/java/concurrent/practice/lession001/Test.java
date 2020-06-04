package com.lzw.java.concurrent.practice.lession001;

/**
 * @Auther: lizhaowen
 * @Date: 2020/6/4 21:28
 * @Description: TODO
 */
public class Test {
    private static long count = 0;
    private void add10K(){
        int idx = 0;
        while (idx++<100000000){
            count+=1;
        }
    }
    public static long calc() throws InterruptedException {
        final Test test = new Test();
        // 创建两个线程,执行add()操作
        Thread thread1 = new Thread(() -> {
            test.add10K();
        });
        Thread thread2 = new Thread(() -> {
            test.add10K();
        });
        // 启动两个线程
        thread1.start();
        thread2.start();
        // 等待两个线程执行结束
        thread1.join();
        thread2.join();
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        long calc = calc();
        System.out.println(calc);
    }
}
