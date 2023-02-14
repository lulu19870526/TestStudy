package leetcode.niuke.suanfa;

import java.util.ArrayList;


/**
 * @Author: zengqx
 * @Date: 2023/2/12 17:08
 */
public class NC305 {

    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(8);
        list.add(6);
        list.add(2);
        list.add(1);
        list.add(1);
        list.add(9);
        list.add(7);
        list.add(5);
        list.add(4);
        list.add(3);
        int result = findRepeatNum(list);
        System.out.println(result);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型ArrayList
     * @return int整型
     */
    public static int findRepeatNum (ArrayList<Integer> nums) {
        // write code here
        int[] arr = new int[nums.size()];
        for(int i = 0;i < nums.size();i++){
            arr[nums.get(i)]++;
            if(arr[nums.get(i)] == 2){
                return nums.get(i);
            }
        }
        return -1;
    }
}
