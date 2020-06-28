package com.lzw.java.concurrent.practice.lession022;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Auther: lizhaowen
 * @Date: 2020/6/21 20:01
 * @Description: 简化的线程池, 仅仅用来说明工作原理
 */
public class MyThreadPool {
    // 利用阻塞队列实现生产者-消费者模式
    BlockingQueue<Runnable> workQueue;
    // 保存内部工作线程
    List<WorkThread> threads = new ArrayList<>();

    // 构造方法
    MyThreadPool(int poolSize, BlockingQueue<Runnable> workQueue) {
        this.workQueue = workQueue;
        // 创建工作线程
        for (int idx = 0; idx < poolSize; idx++) {
            WorkThread work = new WorkThread();
            work.start();
            threads.add(work);
        }
    }

    // 提交任务
    void execute(Runnable command) throws InterruptedException {
        workQueue.put(command);
    }

    class WorkThread extends Thread {
        public void run() {
            // 循环获取任务并执行
            while (true) {
                try {
                    Runnable task = workQueue.take();
                    task.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(2);
        MyThreadPool pool = new MyThreadPool(10, workQueue);
        // 提交任务
        pool.execute(() -> {
            System.out.println("hello");
        });
    }
}
