package com.lzw.java.design.patterns.behavior.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: lizhaowen
 * @Date: 2020/8/7 19:32
 * @Description: TODO
 */
public class ConcreteSubject implements Subject{
    private List<Observer> observers = new ArrayList<>();


    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver(Message message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
