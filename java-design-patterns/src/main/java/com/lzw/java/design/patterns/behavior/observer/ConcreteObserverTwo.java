package com.lzw.java.design.patterns.behavior.observer;

/**
 * @Auther: lizhaowen
 * @Date: 2020/8/7 19:36
 * @Description: TODO
 */
public class ConcreteObserverTwo implements Observer{
    @Override
    public void update(Message message) {
        System.out.println("ConcreteObserverTwo is notified");
    }
}
