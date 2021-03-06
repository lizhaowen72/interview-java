package com.lzw.java.mq;

import org.apache.commons.lang3.time.StopWatch;

import java.util.LinkedList;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: lizhaowen
 * @Date: 2020/7/11 18:41
 * @Description: TODO
 */
public class CASThread  implements Runnable{
    private AtomicInteger total;
    private CountDownLatch latch;

    public CASThread(AtomicInteger total, CountDownLatch latch) {
        this.total = total;
        this.latch = latch;
    }

    @Override
    public void run() {
        while (!total.compareAndSet(total.get(), total.get() + 1)){}
        latch.countDown();
    }

    public static void main(String[] args) throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        CountDownLatch latch = new CountDownLatch(10000);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10000, 10000, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        for (int i = 0; i < 10000; i ++) {
            executor.execute(new CASThread(atomicInteger, latch));
        }
        latch.await();
        System.out.println(atomicInteger.get());
        System.out.println("消耗：" + stopWatch.getTime() + "ms");
        LinkedList<String> list = new LinkedList<>();
        CompletableFuture.runAsync(() -> new Object());
    }
}
