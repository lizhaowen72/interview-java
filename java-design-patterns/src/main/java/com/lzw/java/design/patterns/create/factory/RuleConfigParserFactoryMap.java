package com.lzw.java.design.patterns.create.factory;

import com.lzw.java.design.patterns.create.factory.service.IRuleConfigParserFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: lizhaowen
 * @Date: 2020/7/11 14:36
 * @Description: TODO
 */
public class RuleConfigParserFactoryMap {
    private static final Map<String, IRuleConfigParserFactory> cachedFactorys = new HashMap<>();

    static {
        cachedFactorys.put("json", new JsonRuleConfigParserFactory());
        cachedFactorys.put("xml", new XmlRuleConfigParserFactory());
        cachedFactorys.put("yaml", new YamlRuleConfigParserFactory());
        cachedFactorys.put("properties", new PropertiesRuleConfigParserFactory());
    }

    public static IRuleConfigParserFactory getParserFactory(String type) {
        if (type == null || type.isEmpty()) {
            return null;
        }
        IRuleConfigParserFactory parserFactory = cachedFactorys.get(type.toLowerCase());
        return parserFactory;
    }
}
