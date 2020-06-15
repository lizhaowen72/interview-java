package com.lzw.java.concurrent.practice.lession009;

/**
 * @Auther: lizhaowen
 * @Date: 2020/6/13 15:54
 * @Description: TODO
 */
public class Worker extends Thread {

    @Override
    public void run() {
        int i = 0;
        while (i < 20) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println(Thread.currentThread().getName() + "检测到当前线程被中断");
                break;
            }
            ++i;
            System.out.println(Thread.currentThread().getName() + "i: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}
