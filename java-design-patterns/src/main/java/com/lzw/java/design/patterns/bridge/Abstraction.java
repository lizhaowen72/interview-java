package com.lzw.java.design.patterns.bridge;
// 抽象化角色
public abstract  class Abstraction {
    protected Implementor imple;
    protected Abstraction(Implementor imple){
        this.imple = imple;
    }
    public abstract void operation();
}
