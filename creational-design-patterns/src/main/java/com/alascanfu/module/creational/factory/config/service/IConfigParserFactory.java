package com.alascanfu.module.creational.factory.config.service;

/**
 * <p>
 *
 * </p>
 *
 * @author Fu JIAWEI
 * @since 2023/5/8 0:24
 **/
public interface IConfigParserFactory {
    IRuleConfigParser createRuleParser();
    
    ISystemConfigParser createSystemParser();
}
