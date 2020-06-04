package com.lzw.java.concurrent.practice.lession001;

/**
 * @Auther: lizhaowen
 * @Date: 2020/6/4 22:16
 * @Description: 线程join()规则
 */
public class ThreadJoin {
    static int var = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread b = new Thread(()->{
            // 此处对共享变量var修改
            var = 66;
        });
        // 例如此处对共享变量修改
        // 则这个修改结果对线程b可见
        // 主线程启动子线程
        b.start();
        // main线程等待子线程b完成
        b.join();
        // 子线程所有对共享变量的修改,在主线程调用b.join()之后皆可见
        System.out.println(var);
    }

}
