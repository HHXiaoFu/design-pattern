package com.alascanfu.module.creational.factory.config.service.impl;

import com.alascanfu.module.creational.factory.config.service.IRuleConfigParser;
import com.alascanfu.module.creational.factory.config.service.IRuleConfigParserFactory;

/**
 * <p>
 * JSON 配置文件解析工厂
 * </p>
 *
 * @author Fu JIAWEI
 * @since 2023/5/8 0:01
 **/
public class JsonRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new JsonRuleConfigParser();
    }
}
