package com.lzw.java.design.patterns.create.singleton;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Auther: lizhaowen
 * @Date: 2020/7/11 11:18
 * @Description: 线程内唯一 线程之间不唯一单例类
 */
public class ThreadSafeIdGenerator {
    private AtomicLong id = new AtomicLong(0);
    public static ConcurrentHashMap<Long, ThreadSafeIdGenerator> instance = new ConcurrentHashMap<>();

    private ThreadSafeIdGenerator() {

    }

    public static ThreadSafeIdGenerator getInstance() {
        // putIfAbsent如果key对应的值已经存在内存中,不会进行替换,并且返回旧值,put会进行替换
        instance.putIfAbsent(Thread.currentThread().getId(), new ThreadSafeIdGenerator());
        return instance.get(Thread.currentThread().getId());
    }

    public long getId(){
        return id.incrementAndGet();
    }
}
