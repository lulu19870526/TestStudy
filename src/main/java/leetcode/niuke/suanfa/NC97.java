package leetcode.niuke.suanfa;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author: zengqx
 * @Date: 2023/1/25 19:36
 */
public class NC97 {

    public static void main(String[] args){
        String[] strings = {"1","1","9","9","7","8"};
        String[][] arr = topKstrings(strings,3);
        System.out.println(arr);
    }

    /**
     * return topK string
     * @param strings string字符串一维数组 strings
     * @param k int整型 the k
     * @return string字符串二维数组
     */
    public static String[][] topKstrings (String[] strings, int k) {
        // write code here
        if (strings == null || strings.length == 0 || k == 0) {
            return new String[][] {};
        }
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String str : strings) {
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
        }

        Comparator<Map.Entry<String,Integer>> comparator = new Comparator<
                        Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> entry1,
                               Map.Entry<String, Integer> entry2) {
                if (entry1.getValue().intValue() != entry2.getValue().intValue()) {
                    return  entry1.getValue() - entry2.getValue();
                } else {
                    return entry2.getKey().compareTo(entry1.getKey());
                }
            }
        };

        PriorityQueue<Map.Entry<String, Integer>> queue = new
                PriorityQueue<Map.Entry<String, Integer>>(k, comparator);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (queue.size() < k) {
                queue.offer(entry);
            } else {
                if (comparator.compare(queue.peek(), entry) < 0) {
                    queue.poll();
                    queue.offer(entry);
                }
            }
        }
        String[][] resultArr = new String[k][2];
        for (int i = k - 1; i >= 0; i--) {
            Map.Entry<String, Integer> entry = queue.poll();
            resultArr[i][0] = entry.getKey();
            resultArr[i][1] = String.valueOf(entry.getValue());
        }
        return resultArr;
    }
}
