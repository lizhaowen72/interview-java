package com.lzw.java.design.patterns.behavior.observer.eventbus;

import com.google.common.base.Preconditions;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Auther: lizhaowen
 * @Date: 2020/8/7 20:16
 * @Description: TODO
 */
public class ObserverAction {
    private Object target;

    private Method method;

    public ObserverAction(Object target, Method method) {
        this.target = Preconditions.checkNotNull(target);
        this.method = method;
        this.method.setAccessible(true);
    }
    public void execute(Object event){
        try {
            method.invoke(target,event);
        }catch (InvocationTargetException|IllegalAccessException e){
            e.printStackTrace();
        }
    }
}
