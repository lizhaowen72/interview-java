package com.lzw.java.concurrent.practice.lession026;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * @Auther: lizhaowen
 * @Date: 2020/8/2 11:30
 * @Description: TODO
 */
public class ForkJoinDemo {
    static class Fibonacci extends RecursiveTask<Integer> {
        final int n;

        public Fibonacci(int n) {
            this.n = n;
        }

        @Override
        protected Integer compute() {
            if (n <= 1) {
                return n;
            }
            Fibonacci f1 = new Fibonacci(n - 1);
            // 创建子任务
            f1.fork();
            Fibonacci f2 = new Fibonacci(n - 2);
            //等待子任务结果,并合并结果
            return f2.compute() + f1.join();
        }
    }

    public static void main(String[] args) {
        // 创建分治任务线程池
        ForkJoinPool fjp = new ForkJoinPool(4);
        // 创建分治任务
        Fibonacci fib = new Fibonacci(7);
        // 启动分治任务
        Integer result = fjp.invoke(fib);
        // 输出结果
        System.out.println(result);
    }

}

