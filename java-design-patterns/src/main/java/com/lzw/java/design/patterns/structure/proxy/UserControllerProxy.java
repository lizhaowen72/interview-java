package com.lzw.java.design.patterns.structure.proxy;

/**
 * @Auther: lizhaowen
 * @Date: 2020/7/11 16:07
 * @Description: TODO
 */
public class UserControllerProxy implements IUserController {
    private MetricsCollector metricsCollector;
    private UserController userController;

    public UserControllerProxy(MetricsCollector metricsCollector, UserController userController) {
        this.metricsCollector = metricsCollector;
        this.userController = userController;
    }

    @Override
    public UserVo login(String telephone, String password) {
        long startTimeStamp = System.currentTimeMillis();
        //委托
        UserVo userVo = userController.login(telephone, password);
        long endTimeStamp = System.currentTimeMillis();
        long respTime = endTimeStamp - startTimeStamp;
        RequestInfo requestInfo = new RequestInfo("login", respTime, startTimeStamp);
        metricsCollector.recordRequest(requestInfo);
        // 返回userVO数据
        return userVo;
    }

    @Override
    public UserVo register(String telephone, String password) {
        long startTimeStamp = System.currentTimeMillis();
        //委托
        UserVo userVo = userController.register(telephone, password);
        long endTimeStamp = System.currentTimeMillis();
        long respTime = endTimeStamp - startTimeStamp;
        RequestInfo requestInfo = new RequestInfo("login", respTime, startTimeStamp);
        metricsCollector.recordRequest(requestInfo);
        // 返回userVO数据
        return userVo;
    }
}
