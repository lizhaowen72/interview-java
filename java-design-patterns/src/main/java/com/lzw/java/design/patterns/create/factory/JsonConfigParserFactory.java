package com.lzw.java.design.patterns.create.factory;

import com.lzw.java.design.patterns.create.factory.service.IConfigParserFactory;
import com.lzw.java.design.patterns.create.factory.service.IRuleConfigParser;
import com.lzw.java.design.patterns.create.factory.service.ISystemConfigParser;

/**
 * @Auther: lizhaowen
 * @Date: 2020/7/11 14:53
 * @Description: TODO
 */
public class JsonConfigParserFactory implements IConfigParserFactory {

    @Override
    public IRuleConfigParser createRuleParser() {
        return new JsonRuleConfigParser();
    }

    @Override
    public ISystemConfigParser createSystemParser() {
        return new JsonSystemConfigParser();
    }
}
