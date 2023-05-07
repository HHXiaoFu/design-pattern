package com.alascanfu.module.creational.factory.config.implement;

import com.alascanfu.module.creational.factory.config.entity.RuleConfig;
import com.alascanfu.module.creational.factory.config.exception.InvalidRuleConfigException;
import com.alascanfu.module.creational.factory.config.service.IRuleConfigParser;
import com.alascanfu.module.creational.factory.config.service.impl.JsonRuleConfigParser;
import com.alascanfu.module.creational.factory.config.service.impl.PropertiesRuleConfigParser;
import com.alascanfu.module.creational.factory.config.service.impl.XmlRuleConfigParser;
import com.alascanfu.module.creational.factory.config.service.impl.YamlRuleConfigParser;

import java.io.File;

/**
 * <p>
 * 简单工厂模式的第一种实现方式（不包含缓存）
 * </p>
 *
 * @author Fu JIAWEI
 * @since 2023/5/7 23:49
 **/
public class SimpleFactoryMethod1 {
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
    
    /**
     * 根据规则配置文件路径获取配置进行加载
     * 同时也是 简单工厂模式的第一种实现方式
     * @param ruleConfigFilePath 规则配置文件路径
     * @return com.alascanfu.module.creational.factory.config.entity.RuleConfig
     */
    public RuleConfig load(String ruleConfigFilePath) {
        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);
        IRuleConfigParser parser = createParser(ruleConfigFileExtension);
        
        if (parser == null) {
            throw new InvalidRuleConfigException("Rule config file format is not supported: " + ruleConfigFilePath);
        }
        
        String configText = "";
        // 从ruleConfigFilePath文件中读取配置文本到configText中
        return parser.parse(configText);
    }
    
    private IRuleConfigParser createParser(String configFormat) {
        IRuleConfigParser parser = null;
        if ("json".equalsIgnoreCase(configFormat)) {
            parser = new JsonRuleConfigParser();
        } else if ("xml".equalsIgnoreCase(configFormat)) {
            parser = new XmlRuleConfigParser();
        } else if ("yaml".equalsIgnoreCase(configFormat)) {
            parser = new YamlRuleConfigParser();
        } else if ("properties".equalsIgnoreCase(configFormat)) {
            parser = new PropertiesRuleConfigParser();
        }
        return parser;
    }
}
