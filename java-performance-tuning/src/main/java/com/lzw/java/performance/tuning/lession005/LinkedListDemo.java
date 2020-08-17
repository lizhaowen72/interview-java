package com.lzw.java.performance.tuning.lession005;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: lizhaowen
 * @Date: 2020/8/16 16:16
 * @Description: TODO
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
