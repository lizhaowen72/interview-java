package com.lzw.java.design.patterns.create.factory;

import com.lzw.java.design.patterns.create.factory.service.IRuleConfigParser;
import com.lzw.java.design.patterns.create.factory.service.IRuleConfigParserFactory;

/**
 * @Auther: lizhaowen
 * @Date: 2020/7/11 14:12
 * @Description: TODO
 */
public class RuleConfigSource {
    public RuleConfig load(String ruleConfigFilePath) throws Exception {
        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);
        IRuleConfigParserFactory parserFactory = RuleConfigParserFactoryMap.getParserFactory(ruleConfigFileExtension);
        if (parserFactory==null){
            throw new Exception("Rule config file format is not supported: " + ruleConfigFileExtension);
        }
        IRuleConfigParser parser = parserFactory.createParser();
        String configText = "";
        // ruleConfigFilePath文件中读取配置文件到configText中
        RuleConfig ruleConfig = parser.parse(configText);
        return ruleConfig;
    }

    private String getFileExtension(String ruleConfigFilePath) {
        return "json";
    }
}
