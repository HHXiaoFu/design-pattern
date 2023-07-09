package com.alascanfu.module.speculation.test;

import com.alascanfu.module.speculation.entity.DynamicArray;
import com.alascanfu.module.speculation.entity.SortedDynamicArray;

/**
 * <p>
 * 多态理论理解测试
 * </p>
 *
 * @author Fu JIAWEI
 * @since 2023/7/2 1:34
 **/
public class Example {
    public static void test(DynamicArray dynamicArray) {
        dynamicArray.add(5);
        dynamicArray.add(1);
        dynamicArray.add(3);
        for (int i = 0; i < dynamicArray.size(); ++i) {
            System.out.println(dynamicArray.get(i));
        }
    }
    
    public static void main(String args[]) {
        DynamicArray dynamicArray = new SortedDynamicArray();
        test(dynamicArray); // 打印结果：1、3、5
    }
}
