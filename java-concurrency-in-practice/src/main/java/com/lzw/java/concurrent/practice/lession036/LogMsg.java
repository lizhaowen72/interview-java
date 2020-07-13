package com.lzw.java.concurrent.practice.lession036;

/**
 * @Auther: lizhaowen
 * @Date: 2020/7/5 17:43
 * @Description: TODO
 */
public class LogMsg {
    LEVEL level;
    String msg;

    public LogMsg(LEVEL level, String msg) {
        this.level = level;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "LogMsg{" +
                "level=" + level +
                ", msg='" + msg + '\'' +
                '}';
    }
}
