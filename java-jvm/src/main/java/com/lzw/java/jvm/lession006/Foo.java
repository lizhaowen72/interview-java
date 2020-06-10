package com.lzw.java.jvm.lession006;

/**
 * @Auther: lizhaowen
 * @Date: 2020/6/10 20:53
 * @Description: TODO
 */
public class Foo {
    private int tryBlock;
    private int catchBlock;
    private int finallyBlock;
    private int methodExit;

    public void test() {
        try {
            tryBlock = 0;
        } catch (Exception e) {
            catchBlock = 1;
        } finally {
            finallyBlock = 2;
        }
        methodExit = 3;
    }

    public static void main(String[] args) {
        new Foo().test();
    }
}
