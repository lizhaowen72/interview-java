package com.lzw.java.design.patterns.create.factory.service;

/**
 * @Auther: lizhaowen
 * @Date: 2020/7/11 14:50
 * @Description: TODO
 */
public interface IConfigParserFactory {
    IRuleConfigParser createRuleParser();
    ISystemConfigParser createSystemParser();
}
