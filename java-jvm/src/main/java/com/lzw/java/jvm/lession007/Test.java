package com.lzw.java.jvm.lession007;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Auther: lizhaowen
 * @Date: 2020/6/11 20:39
 * @Description: TODO
 */
public class Test {
    public static void target(int i) {
        new Exception("#" + i).printStackTrace();
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> kClass = Class.forName("com.lzw.java.jvm.lession007.Test");
        Method method = kClass.getMethod("target", int.class);
        method.invoke(null, 0);
    }
    /**
     *
     // v0版本
     import java.lang.reflect.Method;

     public class Test {
     public static void target(int i) {
     new Exception("#" + i).printStackTrace();
     }

     public static void main(String[] args) throws Exception {
     Class<?> klass = Class.forName("Test");
     Method method = klass.getMethod("target", int.class);
     method.invoke(null, 0);
     }
     }

     # 不同版本的输出略有不同，这里我使用了Java 10。
     $ java Test
     java.lang.Exception: #0
     at Test.target(Test.java:5)
     at java.base/jdk.internal.reflect.NativeMethodAccessorImpl .invoke0(Native Method)
     at java.base/jdk.internal.reflect.NativeMethodAccessorImpl. .invoke(NativeMethodAccessorImpl.java:62)
     t java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.i .invoke(DelegatingMethodAccessorImpl.java:43)
     java.base/java.lang.reflect.Method.invoke(Method.java:564)
     t        Test.main(Test.java:131
     */
}
