package com.lzw.java.design.patterns.structure.bridge;

public class RefinedAbstraction extends  Abstraction{
    public RefinedAbstraction(Implementor imple) {
        super(imple);
    }

    @Override
    public void operation() {
        System.out.println("扩展抽象化角色被访问");
        imple.operationImpl();
    }
}
