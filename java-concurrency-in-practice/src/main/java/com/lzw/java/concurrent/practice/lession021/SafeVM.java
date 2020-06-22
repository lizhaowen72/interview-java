package com.lzw.java.concurrent.practice.lession021;


import java.util.concurrent.atomic.AtomicReference;

/**
 * @Auther: lizhaowen
 * @Date: 2020/6/22 20:24
 * @Description: TODO
 */
public class SafeVM {
    class VMRange{
        final int upper;
        final int lower;

        public VMRange(int upper, int lower) {
            this.upper = upper;
            this.lower = lower;
        }
    }
    final AtomicReference<VMRange> rf = new AtomicReference<>(new VMRange(0,0));
    // 设置库存上限
    void setUpper(int v){
        VMRange nr;
        VMRange or;
        do {
            or = rf.get();
            // 检查参数合法性
            if (v<or.lower){
                throw new IllegalArgumentException();
            }
            nr = new VMRange(v,or.lower);
        }while (!rf.compareAndSet(or,nr));
    }
}
