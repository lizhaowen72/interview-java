package com.lzw.java.design.patterns.builder;


import org.apache.commons.lang3.StringUtils;

/**
 * @Auther: lizhaowen
 * @Date: 2020/7/4 20:07
 * @Description: TODO
 */
public class ResourcePoolConfig {
    private static final int DEFAULT_MAX_TOTAL = 8;
    private static final int DEFAULT_MAX_IDLE = 8;
    private static final int DEFAULT_MIN_IDLE = 0;

    private String name;
    private int maxTotal = DEFAULT_MAX_TOTAL;
    private int maxIdle = DEFAULT_MAX_IDLE;
    private int minIdle = DEFAULT_MIN_IDLE;

    public ResourcePoolConfig(String name, Integer maxTotal, Integer maxIdle, Integer minIdle) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("name should not be empty.");
        }
        this.name = name;
        if (maxTotal != null) {
            if (maxTotal <= 0) {
                throw new IllegalArgumentException("maxTotal should be positive.");
            }
            this.maxTotal = maxTotal;
        }
        if (maxIdle != null) {
            if (maxIdle < 0) {
                throw new IllegalArgumentException("maxIdle should be negative.");
            }
            this.maxIdle = maxIdle;
        }
        if (minIdle != null) {
            if (minIdle < 0) {
                throw new IllegalArgumentException("minIdle should be negative.");
            }
            this.minIdle = minIdle;
        }
    }

    public static void main(String[] args) {

        // 参数太多，导致可读性差、参数可能传递错误
//        ResourcePoolConfig config = new ResourcePoolConfig("dbconnectionpool", 16, null, 8, null, false, true, 10, 20，
//        false，true);
    }
}
