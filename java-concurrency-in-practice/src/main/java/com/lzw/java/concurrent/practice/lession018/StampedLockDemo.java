package com.lzw.java.concurrent.practice.lession018;

import java.util.concurrent.locks.StampedLock;

/**
 * StampedLock和ReadWriteLock的区别
 * ReadWriteLock支持两种模式:一种是读锁,一种是写锁.而StampedLock支持三种模式,分别是:写锁 悲观读锁 和 乐观读.
 * 其中,写锁 悲观读锁的语义和ReadWriteLock的写锁 读锁的语义非常类似,允许多个线程同事获取悲观读锁,但是只允许一个
 * 线程获取写锁,写锁和悲观读锁是互斥的.不同的是:StampedLock里的写锁和悲观读锁加锁成功之后,都会返回一个stamp;然后
 * 解锁的时候,需要传入这个stamp.
 * StampedLock的性能之所以比ReadWriteLock还要好,其关键是StampedLock支持乐观读的方式.ReadWriteLock支持多个线程
 * 同时读,但是当多个线程同时读的时候,所有的写操作会被阻塞;而StampedLock提供的乐观读,是允许一个线程获取写锁的,也就是
 * 说不是所有的写操作被阻塞.乐观读这个操作是无锁的,所以相比较ReadWriteLock的读锁,乐观读的性能更好一些
 */
public class StampedLockDemo {
    public static void main(String[] args) {
        final StampedLock sl = new StampedLock();
        // 获取/释放悲观读锁示例代码
        long stamp = sl.readLock();
        try {
            // 省略业务相关代码
        } finally {
            sl.unlockRead(stamp);
        }
        // 获取/释放写锁示例代码
        long stampWrite = sl.writeLock();
        try {
            // 省略业务相关代码
        } finally {
            sl.unlockWrite(stamp);
        }
    }
}
