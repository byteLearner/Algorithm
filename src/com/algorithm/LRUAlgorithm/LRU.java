package com.algorithm.LRUAlgorithm;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @description: 使用JDK实现LRU算法
 * @author: liuqiang
 * @time: 2021/3/7 21:01
 */
public class LRU<K,V> extends LinkedHashMap<K,V> {
    private int capacity;

    /**
     * accessOrder     he ordering mode -
 *                  <tt>true</tt> for access-order,
 *                  <tt>false</tt> for insertion-order
     * */
    public LRU(int capacity) {
        super(capacity,0.75F,true);
        this.capacity = capacity;
    }

    //删除方法
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        //位置大于最大容量
        return super.size() > capacity;
    }

    public static void main(String[] args) {
        LRU lru = new LRU(3);

        lru.put(1,"a");
        lru.put(2,"b");
        lru.put(3,"c");
        System.out.println(lru.keySet());

        lru.put(4,"d");
        System.out.println(lru.keySet());
        lru.get(2);
        System.out.println(lru.keySet());
    }
}
