package com.alascanfu.module.speculation.entity;

/**
 * <p>
 * ID 生成器
 * </p>
 *
 * @author Fu JIAWEI
 * @since 2023/7/2 0:58
 **/
public class IdGenerator {
    private static String id ;
    public static IdGenerator getInstance(){
        return new IdGenerator();
    }
    
    public static String generate(){
        return id;
    }
}
