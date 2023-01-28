package leetcode.niuke.suanfa;

/**
 * @Author: zengqx
 * @Date: 2023/1/18 9:19
 */
public class NC291 {

    public static void main(String[] args){
        int result = findNthDigit1(1000000000);
        System.out.print(result);
    }

    public static int findNthDigit (int n) {
        // write code here

        int digit = 1;
        int start = 1;
        int sum = 9;
        while (n > sum) {
            n -= sum;
            start *= 10;
            digit ++;
            sum = 9 * start * digit;
        }
        String str = "" + (start + (n - 1) / digit);
        int index = (n - 1) % digit;
        return (int)(str.charAt(index)) - (int)('0');
    }

    public static int findNthDigit1 (int n) {
        //记录n是几位数
        int digit = 1;
        //记录当前位数区间的起始数字：1,10,100...
        long start = 1;
        //记录当前区间之前总共有多少位数字
        long sum = 9;
        //将n定位在某个位数的区间中
        while(n > sum){
            n -= sum;
            start *= 10;
            digit++;
            //该区间的总共位数
            sum = 9 * start * digit;
        }
        //定位n在哪个数字上
        String num = "" + (start + (n - 1) / digit);
        //定位n在数字的哪一位上
        int index = (n - 1) % digit;
        return (int)(num.charAt(index)) - (int)('0');
    }
}
