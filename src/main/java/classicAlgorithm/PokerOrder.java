package classicAlgorithm;


import java.util.Arrays;

/**
 * 从扑克牌中随机抽 5 张牌,判断是不是顺子,即这 5 张牌是不是连续的。
 * 2-10 为数字本身,A 为 1,J 为 11,Q 为 12,K 为 13,而大小王可以看成任意的 数字。
 */
public class PokerOrder {

    /**
     * 思路：
     *
     * 1、首先我们应该关注的是大小王等特殊字符，由于可以当成任意的数字，所有当成0处理。
     * 2、把数组排序，再统计数组中0的个数
     * 3、统计排序之后的数组中相邻数字之间的空缺总数。
     * 4、数组中的非0数字重复出现，则该数组是不连续的。
     * 5、如果空缺的总数小于或者等于0的个数，那么这个数组就是连续的，反之则不连续
     */

    public static boolean isOrderly(int[] number) {
        //1、非空判断
        if (number == null){
            return false;
        }

        //2、计算 0 的个数
        int zero = 0;
        for (int num : number) {
            if (num == 0) {
                zero++;
            }
        }

        //3、将数组排序
        Arrays.sort(number);

        //4、排序完成之后 从非零数据进行两两判断
        int small = zero;
        int big = small + 1;
        int numberGap = 0;

        //5、排除一种情况  相邻数据不相等情况
        //进行循环的基础条件
        while (big < number.length) {
            if (number[small] == number[big]) {
                return false;//有对子的存在
            }
            //统计相邻之间的空格
            numberGap += number[big] - number[small] - 1;
            //所有的数据进行后移一位
            small = big;
            big++;
        }
        //判断所有的间隔与0的个数 小于或者等于则是有序的 否则则是无序的
        return numberGap <= zero;
    }

    public static void main(String args[]){

        int[] number  = {7,0,8,4,0};
        boolean isOrder = isOrderly(number);
        System.out.println("isOrder="+isOrder);
    }


}
