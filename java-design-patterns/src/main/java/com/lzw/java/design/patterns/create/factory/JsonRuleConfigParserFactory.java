package com.lzw.java.design.patterns.create.factory;

import com.lzw.java.design.patterns.create.factory.service.IRuleConfigParser;
import com.lzw.java.design.patterns.create.factory.service.IRuleConfigParserFactory;

/**
 * @Auther: lizhaowen
 * @Date: 2020/7/11 14:38
 * @Description: TODO
 */
public class JsonRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new JsonRuleConfigParser();
    }
}
