package com.lzw.java.concurrent.practice.lession001;

/**
 * @Auther: lizhaowen
 * @Date: 2020/6/6 09:46
 * @Description: TODO
 */
public class Singleton {
    static Singleton instance;

    private Singleton() {
    }

    static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    // new 操作
                    // 1.分配一块内存M
                    // 2.在内存M上初始化Singleton对象
                    // 3.然后M的地址赋值给instance变量
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
