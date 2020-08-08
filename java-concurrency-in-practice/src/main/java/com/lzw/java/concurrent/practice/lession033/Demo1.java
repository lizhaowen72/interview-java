package com.lzw.java.concurrent.practice.lession033;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: lizhaowen
 * @Date: 2020/8/7 13:25
 * @Description: TODO
 */
public class Demo1 {
    static class SafeDateFormat {
        static final ThreadLocal<DateFormat> tl =
                ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        static DateFormat get(){
            return tl.get();
        }
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                DateFormat dateFormat = SafeDateFormat.get();
                System.out.println(dateFormat.format(new Date()));
                DateFormat dateFormat1 = SafeDateFormat.get();
                System.out.println(dateFormat1.format(new Date()));
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                DateFormat dateFormat = SafeDateFormat.get();
                System.out.println(dateFormat.format(new Date()));
                DateFormat dateFormat1 = SafeDateFormat.get();
                System.out.println(dateFormat1.format(new Date()));
            }
        }).start();
    }
}
