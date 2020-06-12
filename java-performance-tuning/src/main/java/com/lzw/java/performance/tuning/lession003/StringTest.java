package com.lzw.java.performance.tuning.lession003;

import org.junit.Assert;

/**
 * @Auther: lizhaowen
 * @Date: 2020/6/6 12:59
 * @Description: TODO
 */
public class StringTest {
    public static void main(String[] args) {
        // 通过字面量的方式创建,abc存储于字符串常量池中
        String str1= "abc";
        // 通过new对象的方式创建字符串对象,引用地址存放在堆内存中,abc则存放在字符串常量池中
        String str2= new String("abc");
        // 由于str2调用了intern()方法,会返回常量池中的数据,地址直接指向常量池
        String str3= str2.intern();
        String str4 = new String(new char[]{'a','b','c'});
        System.out.println(str1==str2);
        System.out.println(str1==str3);
        System.out.println(str1==str4);
        System.out.println(str2==str3);
        System.out.println(str2==str4);
        System.out.println(str3==str4);
    }
}
