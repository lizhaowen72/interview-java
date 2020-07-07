package com.lzw.java.concurrent.practice.lession035;

/**
 * @Auther: lizhaowen
 * @Date: 2020/7/5 10:02
 * @Description: TODO
 */
public class Proxy {
    // 线程终止标志位
    volatile boolean terminated = false;
    boolean started = false;
    // 采集线程
    Thread rptThread;
    // 启动采集功能
    synchronized void start(){
        // 不允许同时启动多个线程
        if (started){
            return;
        }
        started = true;
        terminated=false;
        rptThread = new Thread(()->{
            while (!terminated){
                // 省略采集 回传实现
                report();
                // 每隔2s采集 回传一次数据
                try {
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            }
            // 执行到此说明线程马上终止
            started=false;
        });
        rptThread.start();
    }
    // 终止采集功能如何实现
    synchronized void stop(){
        // 设置中断标志位
        terminated=true;
        // 中断线程rptThread
        rptThread.interrupt();
    }

    private void report() {
    }
}
