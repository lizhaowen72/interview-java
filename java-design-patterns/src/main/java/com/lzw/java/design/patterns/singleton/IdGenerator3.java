package com.lzw.java.design.patterns.singleton;

/**
 * @Auther: lizhaowen
 * @Date: 2020/6/23 21:31
 * @Description: 双重检测
 * 饿汉式不支持延迟加载,懒汉式有性能问题,不支持高并发
 * 存在问题:因为指令重排序,可能会导致IdGenerator3对象被new出来,并且赋值给instance之后,
 * 还没来得及初始化(执行构造函数中的代码逻辑),就被另一个线程使用,这样有可能导致空指针异常,
 * 要解决这个问题,需要给instance变量加上volatile关键字,禁止指令重新排序
 */
public class IdGenerator3 {
    private static IdGenerator3 instance;
    private IdGenerator3(){

    }
    public static IdGenerator3 getInstance(){
        if (instance == null){
            synchronized (IdGenerator3.class){
                if (instance==null){
                    instance = new IdGenerator3();
                }
            }
        }
        return instance;
    }
}
