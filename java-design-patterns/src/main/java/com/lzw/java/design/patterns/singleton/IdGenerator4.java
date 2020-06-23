package com.lzw.java.design.patterns.singleton;

/**
 * @Auther: lizhaowen
 * @Date: 2020/6/23 21:40
 * @Description: 静态内部类
 */
public class IdGenerator4 {
    private IdGenerator4(){}

    /**
     * SingletonHolder是一个静态内部类,当外部类IdGenerator4被加载的时候,
     * 并不会创建SingletonHolder实例对象.只有当调用getInstance()方法时,
     * SingletonHolder才会被加载,这个时候才会创建instance.instance的唯一性
     * 创建过程的线程安全性,都由jvm来保证.所以,这种实现方法既保证了线程安全,又能
     * 做到延迟加载
     */
    private static class SingletonHolder{
        private static final IdGenerator4 instance = new IdGenerator4();
    }
    public static IdGenerator4 getInstance(){
        return SingletonHolder.instance;
    }
}
