package com.lzw.java.design.patterns.behavior.observer;

/**
 * @Auther: lizhaowen
 * @Date: 2020/8/7 19:29
 * @Description: TODO
 */
public interface Subject {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObserver(Message message);
}
