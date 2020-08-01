package com.lzw.java.design.patterns.create.factory;

import com.lzw.java.design.patterns.create.factory.service.IRuleConfigParser;
import com.lzw.java.design.patterns.create.factory.service.IRuleConfigParserFactory;

/**
 * @Auther: lizhaowen
 * @Date: 2020/7/11 14:46
 * @Description: TODO
 */
public class YamlRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new YamlRuleConfigParser();
    }
}
