package com.alascanfu.module.creational.factory.config.service.impl.abstractFactory;

import com.alascanfu.module.creational.factory.config.service.IConfigParserFactory;
import com.alascanfu.module.creational.factory.config.service.IRuleConfigParser;
import com.alascanfu.module.creational.factory.config.service.ISystemConfigParser;
import com.alascanfu.module.creational.factory.config.service.impl.JsonRuleConfigParser;

/**
 * <p>
 * JSON 配置解析工厂（支持系统解析与规则解析）
 * </p>
 *
 * @author Fu JIAWEI
 * @since 2023/5/8 0:26
 **/
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
