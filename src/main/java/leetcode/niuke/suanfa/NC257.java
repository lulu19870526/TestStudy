package leetcode.niuke.suanfa;

/**
 * @Author: zengqx
 * @Date: 2023/2/9 23:54
 */
public class NC257 {

    public static void main(String[] args){
        int result = Sum_Solution(1);
        System.out.println(result);
    }

    public static int Sum_Solution(int n) {
        //通过与运算判断n是否为正数，以结束递归
        System.out.println("n="+n);
        boolean flag = (n > 1) && ((n += Sum_Solution(n - 1)) > 0);
        return n;
    }
}
