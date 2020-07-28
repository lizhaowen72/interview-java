package com.lzw.java.design.patterns.bridge;

public class BridgeTest {
    public static void main(String[] args) {
        Implementor implA = new ConcreteImplA();
        Abstraction abs = new RefinedAbstraction(implA);
        abs.operation();
    }
}
