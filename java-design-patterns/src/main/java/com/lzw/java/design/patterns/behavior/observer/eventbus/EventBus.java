package com.lzw.java.design.patterns.behavior.observer.eventbus;

import com.google.common.util.concurrent.MoreExecutors;

import java.util.List;
import java.util.concurrent.Executor;

/**
 * @Auther: lizhaowen
 * @Date: 2020/8/7 21:06
 * @Description: TODO
 */
public class EventBus {
    private Executor executor;

    private ObserverRegistry registry = new ObserverRegistry();

    public EventBus() {
        this(MoreExecutors.directExecutor());
    }

    public EventBus(Executor executor) {
        this.executor = executor;
    }

    public void register(Object object){
        registry.register(object);
    }

    public void post(Object event){
        List<ObserverAction> matchedObserverActions = registry.getMatchedObserverActions(event);
        for (ObserverAction observerAction : matchedObserverActions) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    observerAction.execute(event);
                }
            });
        }
    }
}
