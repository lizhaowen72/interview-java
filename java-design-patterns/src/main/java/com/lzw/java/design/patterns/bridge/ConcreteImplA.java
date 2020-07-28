package com.lzw.java.design.patterns.bridge;
//具体实现化角色
public class ConcreteImplA implements Implementor {
    @Override
    public void operationImpl() {
        System.out.println("具体实现化角色被访问");
    }
}
