package com.lzw.java.design.patterns.prototype;

import java.io.*;
import java.nio.channels.ServerSocketChannel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: lizhaowen
 * @Date: 2020/7/5 11:23
 * @Description: TODO
 */
public class Demo3 {

    private HashMap<String, SearchWord> currentKeywords = new HashMap<>();

    private long lastUpdateTime = -1;

    public void refresh() {
        // Deep copy
        HashMap<String, SearchWord> newKeywords = new HashMap<>();
        for (Map.Entry<String, SearchWord> entry : currentKeywords.entrySet()) {
            SearchWord searchWord = entry.getValue();
            SearchWord newSearchWord = new SearchWord(searchWord.getKeyWord(), searchWord.getCount(), searchWord.getLastUpdateTime());
            newKeywords.put(entry.getKey(), newSearchWord);
        }
        // 从数据库中取出更新时间>lastUpdateTime的数据,放入到newKeywords中
        List<SearchWord> toBeUpdatedSearchWords = getSearchWords(lastUpdateTime);
        long maxNewUpdatedTime = lastUpdateTime;
        for (SearchWord searchWord : toBeUpdatedSearchWords) {
            if (searchWord.getLastUpdateTime() > maxNewUpdatedTime) {
                maxNewUpdatedTime = searchWord.getLastUpdateTime();
            }
            if (newKeywords.containsKey(searchWord.getKeyWord())) {
                SearchWord oldSearchWord = newKeywords.get(searchWord.getKeyWord());
                oldSearchWord.setCount(searchWord.getCount());
                oldSearchWord.setLastUpdateTime(searchWord.getLastUpdateTime());
            } else {
                newKeywords.put(searchWord.getKeyWord(), searchWord);
            }
        }
        lastUpdateTime = maxNewUpdatedTime;
        currentKeywords = newKeywords;
    }

    private List<SearchWord> getSearchWords(long lastUpdateTime) {
        return null;
    }

    public static Object deepCopy(Object object) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(object);

        ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
        ObjectInputStream oi = new ObjectInputStream(bi);

        return oi.readObject();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SearchWord searchWord = new SearchWord("李小文", 1, 1L);
        SearchWord searchWordCopy = (SearchWord) deepCopy(searchWord);
        System.out.println(searchWord==searchWordCopy);
        System.out.println(searchWordCopy.toString());
    }
}
