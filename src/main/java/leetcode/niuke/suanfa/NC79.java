package leetcode.niuke.suanfa;

import java.util.ArrayList;

/**
 * @Author: zengqx
 * @Date: 2023/1/24 21:37
 */
public class NC79 {
       public static void main(String[] arr){
           int result = GetUglyNumber_Solution1(5);
           System.out.println(result);
       }

    public static int GetUglyNumber_Solution1(int index) {
        if (index == 0) {
            return 0;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        int count = 1;
        int i = 0;
        int j = 0;
        int k = 0;
        while (count < index) {
            list.add(findMin1(list.get(i) * 2, list.get(j) * 3, list.get(k) * 5));
            count ++;
            if (list.get(count - 1) == list.get(i) * 2){
                i++;
            }
            if (list.get(count - 1) == list.get(j) * 3) {
                j++;
            }
            if (list.get(count - 1) == list.get(k) * 5) {
                k++;
            }
        }
        return list.get(count - 1);
    }

    private static int findMin1(int x, int y, int z) {
        int result = x;
        result = result < y ? result : y;
        result = result < z ? result : z;
        return result;
    }


        //寻找三个数中的最小值
        private static int findMin(int x, int y, int z){
            int res = x;
            res = y < res ? y : res;
            res = z < res ? z : res;
            return res;
        }
        public  static int GetUglyNumber_Solution(int index) {
            //排除0
            if(index == 0)
                return 0;
            //按顺序记录丑数
            ArrayList<Integer> num = new ArrayList<>();
            num.add(1);
            //记录这是第几个丑数
            int count = 1;
            //分别代表要乘上2 3 5的下标
            int i = 0, j = 0, k = 0;
            while(count < index){
                //找到三个数中最小的丑数
                num.add(findMin(num.get(i) * 2, num.get(j) * 3, num.get(k) * 5));
                count++;
                //由2与已知丑数相乘得到的丑数，那该下标及之前的在2这里都用不上了
                if(num.get(count - 1) == num.get(i) * 2)
                    i++;
                //由3与已知丑数相乘得到的丑数，那该下标及之前的在3这里都用不上了
                if(num.get(count - 1) == num.get(j) * 3)
                    j++;
                //由5与已知丑数相乘得到的丑数，那该下标及之前的在5这里都用不上了
                if(num.get(count - 1) == num.get(k) * 5)
                    k++;
            }
            return num.get(count - 1);
        }

}
