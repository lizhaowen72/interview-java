package com.lzw.java.design.patterns.create.prototype;

import java.io.Serializable;

/**
 * @Auther: lizhaowen
 * @Date: 2020/7/5 10:56
 * @Description: TODO
 */
public class SearchWord implements Serializable {

    private String keyWord;

    private Long lastUpdateTime;

    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public Long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public SearchWord(String keyWord,Integer count,Long lastUpdateTime) {
        this.keyWord = keyWord;
        this.lastUpdateTime = lastUpdateTime;
        this.count = count;
    }

    @Override
    public String toString() {
        return "SearchWord{" +
                "keyWord='" + keyWord + '\'' +
                ", lastUpdateTime=" + lastUpdateTime +
                ", count=" + count +
                '}';
    }
}
