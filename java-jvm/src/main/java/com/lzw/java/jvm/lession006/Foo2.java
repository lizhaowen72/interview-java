package com.lzw.java.jvm.lession006;

/**
 * @Auther: lizhaowen
 * @Date: 2020/6/10 21:35
 * @Description: TODO
 */


// 编译并用javap -c查看编译后的字节码
public class Foo2 {
    private int tryBlock;
    private int catchBlock;
    private int finallyBlock;
    private int methodExit;

    public static void main(String[] args) {
        new Foo2().test();
    }

    public void test() {
        for (int i = 0; i < 100; i++) {
            try {
                tryBlock = 0;
                if (i < 50) {
                    continue;
                } else if (i < 80) {
                    break;
                } else {
                    return;
                }
            } catch (Exception e) {
                catchBlock = 1;
            } finally {
                finallyBlock = 2;
            }
        }
        methodExit = 3;
    }
}