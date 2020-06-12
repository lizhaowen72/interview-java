package com.lzw.java.jvm.lession006;

/**
 * @Auther: lizhaowen
 * @Date: 2020/6/10 20:42
 * @Description: TODO
 */
public class Test {
    public static void main(String[] args) {
        try {
            mayThrowException();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void mayThrowException() {
    }
}
