package com.lzw.java.design.patterns.singleton;

/**
 * @Auther: lizhaowen
 * @Date: 2020/6/23 21:50
 * @Description: 一种最简单的实现方式，基于枚举类型的单例实现。这种实现方式通过 Java 枚举类型本身的特性，保证了实例创建的线程安全性和实例的唯一性
 */
public enum  IdGenerator5 {
    INSTANCE;
}
