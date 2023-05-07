package com.alascanfu.module.creational.factory.config.entity;

import com.alascanfu.module.creational.factory.config.service.IRuleConfigParser;
import com.alascanfu.module.creational.factory.config.service.impl.JsonRuleConfigParser;
import com.alascanfu.module.creational.factory.config.service.impl.PropertiesRuleConfigParser;
import com.alascanfu.module.creational.factory.config.service.impl.XmlRuleConfigParser;
import com.alascanfu.module.creational.factory.config.service.impl.YamlRuleConfigParser;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 * 规则文件配置解析工厂
 * </p>
 *
 * @author Fu JIAWEI
 * @since 2023/5/7 23:51
 **/
public class RuleConfigParserFactory {
    private static final Map<String, IRuleConfigParser> cachedParsers = new ConcurrentHashMap<>();
    
    /**
     * 静态代码块初始化加载
     */
    static {
        cachedParsers.put("json", new JsonRuleConfigParser());
        cachedParsers.put("xml", new XmlRuleConfigParser());
        cachedParsers.put("yaml", new YamlRuleConfigParser());
        cachedParsers.put("properties", new PropertiesRuleConfigParser());
    }
    
    /**
     * 通过文件后缀从缓存中加载生成对应的 文件解析器
     *
     * @param configFormat 文件后缀
     * @return com.alascanfu.module.creational.factory.config.service.IRuleConfigParser
     */
    public static IRuleConfigParser createParser(String configFormat) {
        if (configFormat == null || configFormat.isEmpty()) {
            return null;
            //返回null还是IllegalArgumentException全凭你自己说了算
        }
        return cachedParsers.get(configFormat.toLowerCase());
    }
}
