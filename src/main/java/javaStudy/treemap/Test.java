package javaStudy.treemap;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


/**
 * treeMap的key按照自然顺序进行排序或根据创建时提供的comparator接口进行排序，
 * TreeMap为增、删、改、查这些操作提供了log(N)的时间开销
 */
public class Test {
    public static void main(String[] args) {
        /**
         * 定义一个新的，空的treeMap，排序规则是key的自然顺序，
         * 所有要存储的元素的key必须实现Comparable接口，而且，这些key要可以互相比较，否则会抛ClassCastException，即类型转换异常。
         * key所属类型String类实现了Comparable接口
         */
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("a","aaa");
        treeMap.put("d","ddd");
        treeMap.put("b","bbb");
        treeMap.put("c","ccc");

        Set<Map.Entry<String, String>> entries = treeMap.entrySet();
        for(Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey() + "========" + entry.getValue());
        }

    }

}
