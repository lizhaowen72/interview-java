package com.lzw.java.design.patterns.behavior.observer;

/**
 * @Auther: lizhaowen
 * @Date: 2020/8/7 19:37
 * @Description: TODO
 */
public class Demo {
    public static void main(String[] args) {
        ConcreteSubject concreteSubject = new ConcreteSubject();
        concreteSubject.registerObserver(new ConcreteObserverOne());
        concreteSubject.registerObserver(new ConcreteObserverTwo());
        concreteSubject.notifyObserver(new Message());
    }
}
