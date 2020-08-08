package com.lzw.java.design.patterns.behavior.observer;

/**
 * @Auther: lizhaowen
 * @Date: 2020/8/7 19:35
 * @Description: TODO
 */
public class ConcreteObserverOne implements Observer{
    @Override
    public void update(Message message) {
        System.out.println("ConcreteObserverOne is notified");
    }
}
