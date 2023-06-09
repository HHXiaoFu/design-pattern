package com.alascanfu.module.speculation.entity;

/**
 * <p>
 * 动态数组
 * </p>
 *
 * @author Fu JIAWEI
 * @since 2023/7/2 1:32
 **/

public class DynamicArray {
    private static final int DEFAULT_CAPACITY = 10;
    protected int size = 0;
    protected int capacity = DEFAULT_CAPACITY;
    protected Integer[] elements = new Integer[DEFAULT_CAPACITY];
    
    public int size() { return this.size; }
    public Integer get(int index) { return elements[index];}
    //...省略n多方法...
    
    public void add(Integer e) {
        ensureCapacity();
        elements[size++] = e;
    }
    
    protected void ensureCapacity() {
        //...如果数组满了就扩容...代码省略...
    }
}
