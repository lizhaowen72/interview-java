package com.lzw.java.concurrent.practice.lession005;

/**
 * @Auther: lizhaowen
 * @Date: 2020/6/7 21:09
 * @Description: 破坏循环等待条件
 * 循环等待,一定是A->B->C->...->N->A形成环状
 * 如果按需申请,是不允许N->A出现的,只能N->P.没有环状,也就不会有死锁了
 *
 * 最常见的就是B转A的同时，A转账给B，那么先锁B再锁A，
 * 但是，另一个线程是先锁A再锁B，然而，如果两个线程同时执行，
 * 那么就是出现死锁的情况，线程T1锁了A请求锁B，此时线程T2锁了B请求锁A，
 * 都在等着对方释放锁，然而自己都不会释放锁，故死锁。
 * 最简单的办法，就是无论哪个线程执行的时候，都按照顺序加锁，
 * 即按照A和B的id大小来加锁，这样，无论哪个线程执行的时候，
 * 都会先加锁A，再加锁B，A被加锁，则等待释放。这样就不会被死锁了
 */
public class Account2 {
    private int id;
    private int balance;
    // 转账
    void transfer(Account2 target,int amt){
        Account2 left = this;    // 1
        Account2 right = target; // 2
        if (this.id>target.id){  // 3
            left =target;        // 4
            right = this;        // 5
        }                        // 6
        // 锁定序号小的账户
        synchronized (left){
            synchronized (right){
                if (this.balance>amt){
                    this.balance-=amt;
                    target.balance+=amt;
                }
            }
        }
    }
}
