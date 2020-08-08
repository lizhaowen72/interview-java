package com.lzw.java.design.patterns.behavior.observer.eventbus;

import java.util.concurrent.Executor;

/**
 * @Auther: lizhaowen
 * @Date: 2020/8/7 21:09
 * @Description: TODO
 */
public class AsyncEventBus extends EventBus{
    public AsyncEventBus(Executor executor) {
        super(executor);
    }
}
