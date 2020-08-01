package com.lzw.java.design.patterns.create.factory.service;

import com.lzw.java.design.patterns.create.factory.RuleConfig;

/**
 * @Auther: lizhaowen
 * @Date: 2020/7/11 14:15
 * @Description: TODO
 */
public interface IRuleConfigParser {
    RuleConfig parse(String configText);
}
