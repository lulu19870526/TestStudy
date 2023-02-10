package leetcode.niuke.suanfa;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: zengqx
 * @Date: 2023/2/10 15:49
 */
public class NC270 {

    public static void main(String[] args){
        String result = PrintMinNumber(new int[]{321});
        System.out.println(result);
    }

    public static String PrintMinNumber(int [] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        String[] arr = new String[numbers.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(arr, new Comparator<String>() {
            public int compare(String str1, String str2) {
                return (str1 + str2).compareTo(str2 + str1);
            }
        });
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            strBuilder.append(arr[i]);
        }
        return strBuilder.toString();
    }
}
