package com.lzw.java.design.patterns.behavior.template.callback;

/**
 * @Auther: lizhaowen
 * @Date: 2020/8/8 10:02
 * @Description: TODO
 */
public class AClass {
    public static void main(String[] args) {
        BClass bClass = new BClass();
        bClass.process(new ICallBack() {
            @Override
            public void methodToCallBack() {
                System.out.println("call back me");
            }
        });
    }
}
