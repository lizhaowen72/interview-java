package com.lzw.java.design.patterns.structure.proxy;

/**
 * @Auther: lizhaowen
 * @Date: 2020/7/11 16:11
 * @Description: TODO
 */
public class UserControllerProxy2 extends UserController{
    private MetricsCollector metricsCollector;

    public UserControllerProxy2(MetricsCollector metricsCollector) {
        this.metricsCollector = metricsCollector;
    }

    public UserVo login(String telephone,String password){
        long startTimeStamp = System.currentTimeMillis();
        //委托
        UserVo userVo = super.login(telephone, password);
        long endTimeStamp = System.currentTimeMillis();
        long respTime = endTimeStamp - startTimeStamp;
        RequestInfo requestInfo = new RequestInfo("login", respTime, startTimeStamp);
        metricsCollector.recordRequest(requestInfo);
        // 返回userVO数据
        return userVo;
    }
    public UserVo register(String telephone,String password){
        long startTimeStamp = System.currentTimeMillis();
        //委托
        UserVo userVo = super.register(telephone, password);
        long endTimeStamp = System.currentTimeMillis();
        long respTime = endTimeStamp - startTimeStamp;
        RequestInfo requestInfo = new RequestInfo("login", respTime, startTimeStamp);
        metricsCollector.recordRequest(requestInfo);
        // 返回userVO数据
        return userVo;
    }

    public static void main(String[] args) {
        //UserController proxy2 = new UserControllerProxy2(new MetricsCollector());

    }
}
