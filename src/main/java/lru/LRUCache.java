package lru;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LRUCache<K, V> {

    private final int MAX_CACHE_SIZE;
    private final float DEFAULT_LOAD_FACTOR = 0.75f;
    LinkedHashMap<K, V> map;

    public LRUCache(int cacheSize) {
        MAX_CACHE_SIZE = cacheSize;
        //根据cacheSize和加载因子计算hashmap的capactiy，+1确保当达到cacheSize上限时不会触发hashmap的扩容，
        //int capacity = (int) Math.ceil(MAX_CACHE_SIZE / DEFAULT_LOAD_FACTOR) + 1;

        //LinkedHashMap的一个构造函数，当参数accessOrder为true时，即会按照访问顺序排序，最近访问的放在最前，最早访问的放在后面
        map = new LinkedHashMap(16, DEFAULT_LOAD_FACTOR, true) {

            //LinkedHashMap自带的判断是否删除最老的元素方法，默认返回false，即不删除老数据
            //我们要做的就是重写这个方法，当满足一定条件时删除老数据
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > MAX_CACHE_SIZE;
            }
        };
    }

    public synchronized void put(K key, V value) {
        map.put(key, value);
    }

    public synchronized V get(K key) {
        return map.get(key);
    }

    public synchronized void remove(K key) {
        map.remove(key);
    }

    public synchronized Set<Map.Entry<K, V>> getAll() {
        return map.entrySet();
    }

    public synchronized int size() {
        return map.size();
    }

    public synchronized void clear() {
        map.clear();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : map.entrySet()) {
            sb.append(String.format("%s:%s ", entry.getKey(), entry.getValue()));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LRUCache<String, Integer> map = new LRUCache<>(3);
        map.put("key1", 1);
        map.put("key2", 2);
        map.put("key3", 3);

        for (Map.Entry<String, Integer> e : map.getAll()){
            System.out.println("第一次"+e.getKey()+"====>"+e.getValue());
        }
        System.out.println("\n");
        map.put("key4", 4);
        for (Map.Entry<String, Integer> e : map.getAll()){
            System.out.println("第二次"+e.getKey()+"====>"+e.getValue());
        }

    }

}
