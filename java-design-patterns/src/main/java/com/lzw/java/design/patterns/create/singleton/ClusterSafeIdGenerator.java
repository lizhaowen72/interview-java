package com.lzw.java.design.patterns.create.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Auther: lizhaowen
 * @Date: 2020/7/11 11:36
 * @Description: 集群唯一单例
 */
public class ClusterSafeIdGenerator {
    private AtomicLong id = new AtomicLong(0);
    private static ClusterSafeIdGenerator instance;
    private static SharedObjectStoreage storeage = new FileShareObject("文件地址");
    private static DistributedLock  lock = new DistributedLock();

    private ClusterSafeIdGenerator(){

    }
    public synchronized static ClusterSafeIdGenerator getInstance(){
        if (instance==null){
            lock.lock();
            instance =storeage.load(ClusterSafeIdGenerator.class);
        }
        return instance;
    }
    public synchronized void freeInstance(){
        storeage.save(this,ClusterSafeIdGenerator.class);
        instance = null;// 释放对象
        lock.unlock();
    }

    public long getId(){
        return id.incrementAndGet();
    }

    public static void main(String[] args) {
        ClusterSafeIdGenerator clusterSafeIdGenerator = new ClusterSafeIdGenerator();
        ClusterSafeIdGenerator idGenerator =clusterSafeIdGenerator.getInstance();
        long id = idGenerator.getId();
        clusterSafeIdGenerator.freeInstance();
    }
}
