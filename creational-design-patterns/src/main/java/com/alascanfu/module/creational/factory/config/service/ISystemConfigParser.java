package com.alascanfu.module.creational.factory.config.service;

import com.alascanfu.module.creational.factory.config.entity.RuleConfig;

/**
 * <p>
 * 系统配置解析器接口
 * </p>
 *
 * @author Fu JIAWEI
 * @since 2023/5/8 0:24
 **/
public interface ISystemConfigParser {
    RuleConfig parse(String configText);
}
