package com.lzw.java.design.patterns.structure.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Auther: lizhaowen
 * @Date: 2020/7/11 16:23
 * @Description: TODO
 */
public class MetricsCollectorProxy {
    private MetricsCollector metricsCollector;

    public MetricsCollectorProxy(MetricsCollector metricsCollector) {
        this.metricsCollector = metricsCollector;
    }

    public Object createProxy(Object proxiedObject){
        Class<?>[] interfaces = proxiedObject.getClass().getInterfaces();
        DynamicProxyHandler handler = new DynamicProxyHandler(proxiedObject);
        return Proxy.newProxyInstance(proxiedObject.getClass().getClassLoader(),interfaces,handler);
    }

    private class DynamicProxyHandler implements InvocationHandler{
        private Object proxiedObject;

        public DynamicProxyHandler(Object proxiedObject) {
            this.proxiedObject = proxiedObject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            long startTimeStamp = System.currentTimeMillis();
            Object result = method.invoke(proxiedObject,args);
            long endTimeStamp = System.currentTimeMillis();
            long respTime = endTimeStamp - startTimeStamp;
            String apiName = proxiedObject.getClass().getName()+":"+method.getName();
            RequestInfo requestInfo = new RequestInfo(apiName, respTime, startTimeStamp);
            metricsCollector.recordRequest(requestInfo);
            // 返回userVO数据
            return result;
        }
    }
}
