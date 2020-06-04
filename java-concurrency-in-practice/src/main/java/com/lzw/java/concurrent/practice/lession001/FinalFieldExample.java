package com.lzw.java.concurrent.practice.lession001;

/**
 * @Auther: lizhaowen
 * @Date: 2020/6/4 22:26
 * @Description: TODO
 */
public class FinalFieldExample {
    final int x;
    int y;
    static FinalFieldExample f;

    public FinalFieldExample() {
        this.x = 3;
        this.y = 4;
    }

    static void  writer(){
        f = new FinalFieldExample();
    }
    static void reader(){
        if (f!=null){
            int i = f.x;
            int j = f.y;
        }
    }
}
