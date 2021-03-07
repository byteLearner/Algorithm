package com.algorithm.LRUAlgorithm;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description: LRU算法实现
 * @author: liuqiang
 * @time: 2021/3/6 15:31
 */
public class LRUCacheImpl implements LRUCache {

    /**
     * 总体思想map负责查找，构建一个虚拟的双向链表，它里面安装一个Node节点，作为数据载体
    */
    class Node<K,V> {
        K key;
        V value;
        Node<K, V> pre;
        Node<K, V> next;

        //1、构造一个Node节点，作为我们的数据载体
        public Node() {
            this.pre = this.next = null;
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.pre = this.next = null;
        }
    }

    //2、构造一个双向链表，里面安放Node
    class DoubleLinkedList<K,V> {
        Node<K,V> head;
        Node<K,V> tail;
        //2.1 构造方法
        public DoubleLinkedList() {
            head = new Node<>();
            tail = new Node<>();
            head.next = tail;
            tail.pre = head;
        }
        //2.2 添加到头
        public void addHead(Node<K,V> node) {
            node.next = head.next;
            node.pre = head;
            head.next.pre = node;
            head.next = node;
        }
        //2.3 删除节点
        public void removeNode(Node<K,V> node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            node.next = null;
            node.pre = null;
        }
        //2.4 获得最后一个节点
        public Node<K,V> getLast() {
            return tail.pre;
        }
    }


    private int cacheSize;
    Map<Integer,Node<Integer, Integer>> map;
    DoubleLinkedList<Integer,Integer> doubleLinkedList;

    public LRUCacheImpl(int cacheSize) {
        this.cacheSize = cacheSize;
        map = new ConcurrentHashMap<>();
        doubleLinkedList = new DoubleLinkedList<>();
    }

    @Override
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node<Integer, Integer> node = map.get(key);
            node.value = value;
            map.put(key,node);
            doubleLinkedList.removeNode(node);
            doubleLinkedList.addHead(node);
        }else {
            if (map.size() == cacheSize) {
                Node<Integer,Integer> last = doubleLinkedList.getLast();
                map.remove(last.key);
                doubleLinkedList.removeNode(last);
            }
            Node<Integer,Integer> nodeNew = new Node<>(key,value);
            map.put(key,nodeNew);
            doubleLinkedList.addHead(nodeNew);
        }
    }

    @Override
    public int get(int key) {
        if (map.containsKey(key)) {
            Node<Integer, Integer> node = map.get(key);
            doubleLinkedList.removeNode(node);
            doubleLinkedList.addHead(node);
            return node.value;
        }
        return -1;
    }

    public static void main(String[] args) {
        LRUCacheImpl lruCache = new LRUCacheImpl(3);

        lruCache.put(1,1);
        System.out.println(lruCache.map.keySet());
        lruCache.put(2,2);
        System.out.println(lruCache.map.keySet());
        lruCache.put(3,3);
        System.out.println(lruCache.map.keySet());

        lruCache.get(1);
        System.out.println(lruCache.map.keySet());
        lruCache.put(4,4);
        System.out.println(lruCache.map.keySet());

    }
}
