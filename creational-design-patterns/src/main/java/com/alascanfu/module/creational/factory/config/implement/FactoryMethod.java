package com.alascanfu.module.creational.factory.config.implement;

import com.alascanfu.module.creational.factory.config.entity.RuleConfig;
import com.alascanfu.module.creational.factory.config.exception.InvalidRuleConfigException;
import com.alascanfu.module.creational.factory.config.service.IRuleConfigParser;
import com.alascanfu.module.creational.factory.config.service.IRuleConfigParserFactory;
import com.alascanfu.module.creational.factory.config.service.impl.JsonRuleConfigParserFactory;
import com.alascanfu.module.creational.factory.config.service.impl.PropertiesRuleConfigParserFactory;
import com.alascanfu.module.creational.factory.config.service.impl.XmlRuleConfigParserFactory;
import com.alascanfu.module.creational.factory.config.service.impl.YamlRuleConfigParserFactory;

import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 * 工厂方法实现
 * </p>
 *
 * @author Fu JIAWEI
 * @since 2023/5/8 0:05
 **/
public class FactoryMethod {
    /**
     * 根据规则配置文件路径获取对应的文件扩展名
     *
     * @param ruleConfigFilePath 规则配置文件路径
     * @return java.lang.String
     */
    public String getFileExtension(String ruleConfigFilePath) {
        File file = new File(ruleConfigFilePath);
        String extension = "";
        try {
            if (file.exists()) {
                String name = file.getName();
                extension = name.substring(name.lastIndexOf("."));
            }
        } catch (Exception e) {
            extension = "";
        }
        return extension;
    }
    
    public RuleConfig load(String ruleConfigFilePath) {
        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);
        IRuleConfigParserFactory parserFactory = RuleConfigParserFactoryMap.getParserFactory(ruleConfigFileExtension);
        
        if (parserFactory == null) {
            throw new InvalidRuleConfigException("Rule config file format is not supported: " + ruleConfigFilePath);
        }
        IRuleConfigParser parser = parserFactory.createParser();
        
        String configText = "";
        // 从ruleConfigFilePath文件中读取配置文本到configText中
        return parser.parse(configText);
    }
    
    static class RuleConfigParserFactoryMap {
        private static final Map<String, IRuleConfigParserFactory> cachedFactories = new ConcurrentHashMap<>();
        
        static {
            cachedFactories.put("json", new JsonRuleConfigParserFactory());
            cachedFactories.put("xml", new XmlRuleConfigParserFactory());
            cachedFactories.put("yaml", new YamlRuleConfigParserFactory());
            cachedFactories.put("properties", new PropertiesRuleConfigParserFactory());
        }
        
        /**
         * 根据扩展名返回对应的 规则配置解析工厂
         *
         * @param type 扩展名
         * @return com.alascanfu.module.creational.factory.config.service.IRuleConfigParserFactory
         */
        public static IRuleConfigParserFactory getParserFactory(String type) {
            if (type == null || type.isEmpty()) {
                return null;
            }
            return cachedFactories.get(type);
        }
    }
}
