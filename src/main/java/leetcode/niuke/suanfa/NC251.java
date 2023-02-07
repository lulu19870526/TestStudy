package leetcode.niuke.suanfa;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zengqx
 * @Date: 2023/2/7 21:17
 */
public class NC251 {

    public static void main(String[] args){
        int result = findKthNum(new int[]{0,2,4,6,7,8,9,9,10,12,17,18},
                new int[]{0,4,6,8,12,13,22,30,30,31,42,43,45},19);
        System.out.println(result);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param arr1 int整型一维数组
     * @param arr2 int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public static int findKthNum (int[] arr1, int[] arr2, int target) {
        // write code here
        int result = 0;
        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<Integer>();
        while (target-- > 0) {
            if (i < arr1.length && j < arr2.length) {
                if (arr1[i] < arr2[j]) {
                    result = arr1[i++];
                } else {
                    result = arr2[j++];
                }
            }else if(i < arr1.length){
                result = arr1[i++];
            }else{
                result = arr2[j++];
            }
            list.add(result);
        }
        return result;
    }
}
