package leetcode.niuke.suanfa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: zengqx
 * @Date: 2023/2/26 16:58
 */
public class NC392 {

    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> meetings = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(5);
        list1.add(9);
        meetings.add(list1);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(16);
        list2.add(8);
       meetings.add(list2);
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(40);
        meetings.add(list3);

        ArrayList<Integer> list4 = new ArrayList<>();
        list4.add(17);
        list4.add(50);
        meetings.add(list4);
        ArrayList<Integer> list5 = new ArrayList<>();
        list5.add(13);
        list5.add(19);
        meetings.add(list5);
        ArrayList<Integer> list6 = new ArrayList<>();
        list6.add(15);
        list6.add(7);
        meetings.add(list6);

        ArrayList<Integer> list7 = new ArrayList<>();
        list7.add(21);
        list7.add(32);
        meetings.add(list7);
        ArrayList<Integer> list8 = new ArrayList<>();
        list8.add(10);
        list8.add(3);
       meetings.add(list8);
        ArrayList<Integer> list9 = new ArrayList<>();
        list9.add(1);
        list9.add(2);
        meetings.add(list9);

        ArrayList<Integer> list10 = new ArrayList<>();
        list10.add(27);
        list10.add(18);
        meetings.add(list10);

        int result = attendmeetings(meetings);
        System.out.println(result);
    }


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param meetings int整型ArrayList<ArrayList<>>
     * @return int整型
     */
    public static int attendmeetings (ArrayList<ArrayList<Integer>> meetings) {
        // write code here
        Collections.sort(meetings,new Comparator<ArrayList<Integer>>(){
            public int compare(ArrayList<Integer> list1,ArrayList<Integer> list2){
                return list1.get(0) - list2.get(0);
            }
        });
        int currentDay = 1;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int result = 0;
        int i = 0;
        int len = meetings.size();
        while( i < len || !queue.isEmpty()){
            while(i < len && meetings.get(i).get(0) == currentDay){
                queue.offer(meetings.get(i).get(1));
                i++;
            }
            while(!queue.isEmpty() && queue.peek() < currentDay){
                queue.poll();
            }
            if(!queue.isEmpty()){
                queue.poll();
                result++;
            }
            currentDay++;
        }
        return result;
    }
}
