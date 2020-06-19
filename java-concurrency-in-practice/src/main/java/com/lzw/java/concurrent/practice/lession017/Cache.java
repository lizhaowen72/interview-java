package com.lzw.java.concurrent.practice.lession017;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Cache<K,V> {
    final Map<K,V> m= new HashMap<>();
    final ReadWriteLock rwl = new ReentrantReadWriteLock();
    // 读锁
    final Lock r = rwl.readLock();
    // 写锁
    final Lock w = rwl.writeLock();
    // 读缓存
    V get(K key){
        r.lock();
        try {
           return m.get(key);
        }finally {
            r.unlock();
        }
    }
    // 写缓存
    void put(K key,V value){
        w.lock();
        try {
            m.put(key,value);
        }finally {
            w.unlock();
        }
    }
}
