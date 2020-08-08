package com.lzw.java.design.patterns.behavior.template.callback;

/**
 * @Auther: lizhaowen
 * @Date: 2020/8/8 10:01
 * @Description: TODO
 */
public class BClass {

    public void process(ICallBack callBack){
        System.out.println("1");
        callBack.methodToCallBack();
        System.out.println(2);
    }
}
