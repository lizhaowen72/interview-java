package com.lzw.java.design.patterns.create.builder;

import org.apache.commons.lang3.StringUtils;

/**
 * @Auther: lizhaowen
 * @Date: 2020/7/4 20:24
 * @Description: TODO
 */
public class ResourcePoolConfig2 {
    private String name;
    private Integer maxTotal;
    private Integer maxIdle;
    private Integer minIdle;

    private ResourcePoolConfig2(Builder builder) {

    }

    //我们Builder类设计成ResourcePoolConfig2的内部类
    // 我们也可以将Builder类设计成独立的非内部类ResourcePoolConfigBuilder
    public static class Builder {
        private static final int DEFAULT_MAX_TOTAL = 8;
        private static final int DEFAULT_MAX_IDLE = 8;
        private static final int DEFAULT_MIN_IDLE = 0;
        private String name;
        private int maxTotal = DEFAULT_MAX_TOTAL;
        private int maxIdle = DEFAULT_MAX_IDLE;
        private int minIdle = DEFAULT_MIN_IDLE;

        public ResourcePoolConfig2 build() {
            // 检验逻辑放到这里来做,包括必填项校验 依赖关系校验 约束条件校验
            if (StringUtils.isBlank(name)) {
                throw new IllegalArgumentException("...");
            }
            if (maxIdle > maxTotal) {
                throw new IllegalArgumentException("...");
            }
            if (minIdle > maxTotal || minIdle > maxIdle) {
                throw new IllegalArgumentException("...");
            }
            return new ResourcePoolConfig2(this);
        }

        public Builder setName(String name) {
            if (StringUtils.isBlank(name)) {
                throw new IllegalArgumentException("...");
            }
            this.name = name;
            return this;
        }

        public Builder setMaxTotal(int maxTotal) {
            if (maxTotal <= 0) {
                throw new IllegalArgumentException("...");
            }
            this.maxTotal = maxTotal;
            return this;
        }

        public Builder setMaxIdle(int maxIdle) {
            if (maxIdle < 0) {
                throw new IllegalArgumentException("...");
            }
            this.maxIdle = maxIdle;
            return this;
        }

        public Builder setMinIdle(int minIdle) {
            if (minIdle < 0) {
                throw new IllegalArgumentException("...");
            }
            this.minIdle = minIdle;
            return this;
        }
    }


    public String getName() {
        return name;
    }

    public Integer getMaxTotal() {
        return maxTotal;
    }

    public Integer getMaxIdle() {
        return maxIdle;
    }

    public Integer getMinIdle() {
        return minIdle;
    }

    public static void main(String[] args) {
        ResourcePoolConfig2 config2 = new Builder().setName("dbconnectionpool1").setMaxTotal(16).setMaxIdle(10).setMinIdle(12).build();
    }
}
