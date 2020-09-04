package com.lzw.java.core;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Auther: lizhaowen
 * @Date: 2020/9/2 15:27
 * @Description: TODO
 */
public class Demo {
    public static void main(String[] args) {
        int[] nums = {1, 5, 3, 4};
        helper(nums);
    }

    /**
     * 一个方法,这个方法处理int[],返回第一大和第二大的数组
     * 时间复杂度
     */
    public static int[] helper(int[] nums) {
        if (nums == null || nums.length < 2) return nums;
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int num : nums) {
            queue.add(num);
        }
        Integer first = queue.poll();
        Integer second = queue.poll();
        int[] res = {first, second};
        return res;
    }
}
