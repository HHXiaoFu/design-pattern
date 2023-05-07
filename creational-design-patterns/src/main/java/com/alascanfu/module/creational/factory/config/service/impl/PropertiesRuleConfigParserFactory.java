package com.alascanfu.module.creational.factory.config.service.impl;

import com.alascanfu.module.creational.factory.config.service.IRuleConfigParser;
import com.alascanfu.module.creational.factory.config.service.IRuleConfigParserFactory;

/**
 * <p>
 * PROPERTIES 文件配置解析工厂
 * </p>
 *
 * @author Fu JIAWEI
 * @since 2023/5/8 0:03
 **/
public class PropertiesRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new PropertiesRuleConfigParser();
    }
}
