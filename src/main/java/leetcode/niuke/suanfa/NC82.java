package leetcode.niuke.suanfa;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: zengqx
 * @Date: 2023/3/2 22:15
 */
public class NC82 {

    public static void main(String[] args){
        ArrayList<Integer> list = maxInWindows(new int[]{2,3,4,2,6,2,5,1},3);
    }


    public static ArrayList<Integer> maxInWindows(int [] num, int size) {
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(
                new Comparator<int[]>(){
                    public int compare(int[] pair1,int[] pair2){
                        return (pair1[0] != pair2[0])? pair2[0] - pair1[0]:pair2[1] - pair1[1];
                    }
                }
        );
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0;i < size;i++){
            queue.offer(new int[]{num[i],i});
        };
        list.add(queue.peek()[0]);
        for(int i = size;i < num.length;i++){
            queue.offer(new int[]{num[i],i});
            while(queue.peek()[1] <= (i -size)){
                queue.poll();
            }
            list.add(queue.peek()[0]);
        }
        return list;
    }
}
