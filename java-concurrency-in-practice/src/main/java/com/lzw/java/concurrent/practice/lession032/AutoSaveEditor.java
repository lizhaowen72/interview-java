package com.lzw.java.concurrent.practice.lession032;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: lizhaowen
 * @Date: 2020/7/4 11:06
 * @Description: Balking模式本质上是一种规范化的解决"多线程版本的if"的方案
 */
public class AutoSaveEditor {
    // 文件是否被修改过
    boolean changed = false;
    // 定时任务线程池
    ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();

    // 定时执行自动保存
    void startAutoSave() {
        ses.scheduleWithFixedDelay(() -> {
            autoSave();
        }, 5, 5, TimeUnit.SECONDS);
    }

    // 自动存盘操作
    private void autoSave() {
        synchronized (this){
            if (!changed) {
                return;
            }
            changed = false;
        }
        // 执行存盘操作
        // 省略且实现
        this.execSave();
    }

    private void execSave() {
    }

    // 编辑操作
    void edit() {
        // 省略编辑逻辑
        change();
    }

    private void change() {
        synchronized (this){
            changed = true;
        }
    }
}
