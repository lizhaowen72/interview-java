package com.lzw.java.design.patterns.structure.proxy;

import java.util.List;
import java.util.Map;

/**
 * @Auther: lizhaowen
 * @Date: 2020/7/11 15:55
 * @Description: TODO
 */
public class RedisMetricsStorage  implements MetricsStorage {

        @Override
        public void saveRequestInfo(com.lzw.java.design.patterns.structure.proxy.RequestInfo requestInfo) {

        }

        public List<com.lzw.java.design.patterns.structure.proxy.RequestInfo> getRequestInfos(String apiName, long startTimestamp, long endTimestamp) {
            //...
            return null;
        }

        @Override
        public Map<String, List<com.lzw.java.design.patterns.structure.proxy.RequestInfo>> getRequestInfos(long startTimestamp, long endTimestamp) {
            //...
            return null;
        }
}
