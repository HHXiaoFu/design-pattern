package com.alascanfu.module.creational.factory.config.exception;

/**
 * <p>
 * 非法文件解析异常
 * </p>
 *
 * @author Fu JIAWEI
 * @since 2023/5/7 23:42
 **/
public class InvalidRuleConfigException extends RuntimeException {
    public InvalidRuleConfigException(String message) {
        super(message);
    }
}
