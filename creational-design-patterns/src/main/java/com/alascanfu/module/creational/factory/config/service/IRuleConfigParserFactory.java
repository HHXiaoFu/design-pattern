package com.alascanfu.module.creational.factory.config.service;

/**
 * <p>
 * 规则配置解析工厂接口
 * </p>
 *
 * @author Fu JIAWEI
 * @since 2023/5/8 0:00
 **/
public interface IRuleConfigParserFactory {
    IRuleConfigParser createParser();
}
