package com.lzw.java.lock.zook;

/**
 * @Auther: lizhaowen
 * @Date: 2020/9/12 11:14
 * @Description: TODO
 */
public class RespMsg<T> {

    private Boolean flag;

    public RespMsg(Boolean flag) {
        this.flag = flag;
    }

    public static RespMsg<Boolean> success(Boolean flag) {

        return null;
    }
}
