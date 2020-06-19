package com.lzw.java.concurrent.practice.lession019;

import java.util.Vector;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CyclicBarrierDemo<P, D> {
    // 订单队列
    Vector<P> pos;
    // 派送单队列
    Vector<D> dos;
    // 执行回调的线程池
    Executor executor = Executors.newFixedThreadPool(1);
    final CyclicBarrier barrier = new CyclicBarrier(2, () -> {
        executor.execute(() -> check());
    });

    private void check() {
        P p = pos.remove(0);
        D d = dos.remove(0);
        // 执行对账操作
        Object diff = check(p, d);
        // 差异写入差异库
        save(diff);
    }

    private void save(Object diff) {
    }

    private Object check(P p, D d) {
        return null;
    }
}
