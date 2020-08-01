package com.lzw.java.design.patterns.structure.proxy;

/**
 * @Auther: lizhaowen
 * @Date: 2020/7/11 15:52
 * @Description: TODO
 */
public class UserController implements IUserController {
    private MetricsCollector metricsCollector;

    public UserVo login(String telephone, String password) {
        long startTimeStamp = System.currentTimeMillis();
        // .... 省略login逻辑
        long endTimeStamp = System.currentTimeMillis();
        long respTime = endTimeStamp - startTimeStamp;
        RequestInfo requestInfo = new RequestInfo("login", respTime, startTimeStamp);
        metricsCollector.recordRequest(requestInfo);
        // 返回userVO数据
        return null;
    }

    public UserVo register(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();
        // ... 省略register逻辑...
        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;
        RequestInfo requestInfo = new RequestInfo("register", responseTime, startTimestamp);
        metricsCollector.recordRequest(requestInfo);
        //...返回UserVo数据...
        return null;
    }
}
