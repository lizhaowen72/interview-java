package com.lzw.java.design.patterns.create.factory;

import com.lzw.java.design.patterns.create.factory.service.IRuleConfigParser;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: lizhaowen
 * @Date: 2020/7/11 14:25
 * @Description: TODO
 */
public class RuleConfigParserFactory {
    private static final Map<String, IRuleConfigParser> cachedParsers = new HashMap<>();

    static {
        cachedParsers.put("json", new JsonRuleConfigParser());
        cachedParsers.put("xml", new XmlRuleConfigParser());
        cachedParsers.put("yaml", new YamlRuleConfigParser());
        cachedParsers.put("properties", new PropertiesRuleConfigParser());
    }

    public static IRuleConfigParser createParser(String configFormat) {
        if (configFormat == null || configFormat.isEmpty()) {
            return null;
        }
        IRuleConfigParser parser = cachedParsers.get(configFormat.toLowerCase());
        return parser;
    }
}
