package com.lzw.java.design.patterns.create.prototype;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: lizhaowen
 * @Date: 2020/7/5 10:55
 * @Description: TODO
 */
public class Demo {
    private ConcurrentHashMap<String, SearchWord> currentKeywords = new ConcurrentHashMap<>();
    private long lastUpdateTime = -1;

    public void refresh() {
        // 从数据库中取出更新时间>lastUpdateTime的数据,放入到currentKeywords中
        List<SearchWord> toBeUpdateSearchWords = getSearchWords(lastUpdateTime);
        long maxNewUpdateTime = lastUpdateTime;
        for (SearchWord searchWord : toBeUpdateSearchWords) {
            if (searchWord.getLastUpdateTime() > maxNewUpdateTime) {
                maxNewUpdateTime = searchWord.getLastUpdateTime();
            }
            if (currentKeywords.containsKey(searchWord.getKeyWord())) {
                currentKeywords.replace(searchWord.getKeyWord(), searchWord);
            } else {
                currentKeywords.put(searchWord.getKeyWord(), searchWord);
            }
        }
        lastUpdateTime = maxNewUpdateTime;
    }

    private List<SearchWord> getSearchWords(long lastUpdateTime) {
        // TODO:从数据库中取出更新时间>lastUpdateTime的数据
        return null;
    }
}
