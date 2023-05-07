package com.alascanfu.module.creational.factory.config.service;

import com.alascanfu.module.creational.factory.config.entity.RuleConfig;

/**
 * <p>
 * 规则配置文件解析接口
 * </p>
 *
 * @author Fu JIAWEI
 * @since 2023/5/7 23:37
 **/
public interface IRuleConfigParser {
    RuleConfig parse(String configText);
}
