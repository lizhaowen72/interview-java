package com.lzw.java.design.patterns.structure.proxy;


import java.util.List;
import java.util.Map;

/**
 * @Auther: lizhaowen
 * @Date: 2020/7/11 15:55
 * @Description: TODO
 */

public interface MetricsStorage {
    void saveRequestInfo(RequestInfo requestInfo);

    List<RequestInfo> getRequestInfos(String apiName, long startTimeInMillis, long endTimeInMillis);

    Map<String, List<RequestInfo>> getRequestInfos(long startTimeInMillis, long endTimeInMillis);
}