package com.alascanfu.module.creational.factory.config.service.impl;

import com.alascanfu.module.creational.factory.config.service.IRuleConfigParser;
import com.alascanfu.module.creational.factory.config.service.IRuleConfigParserFactory;

/**
 * <p>
 * XML 文件配置解析工厂
 * </p>
 *
 * @author Fu JIAWEI
 * @since 2023/5/8 0:02
 **/
public class XmlRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new XmlRuleConfigParser();
    }
}
