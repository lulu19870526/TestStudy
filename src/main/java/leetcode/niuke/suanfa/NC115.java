package leetcode.niuke.suanfa;

import java.util.Stack;

/**
 * @Author: zengqx
 * @Date: 2023/1/26 13:53
 */
public class NC115 {

    public static void main(String[] args){
        int[] resultArr = solve(new int[]{5,8,9,6,7,1,3,2,4});
    }

    /**
     * 栈排序
     * @param a int整型一维数组 描述入栈顺序
     * @return int整型一维数组
     */
    public static int[] solve (int[] a) {
        // write code here
        int[] maxArr = new int[a.length];
        int max = Integer.MIN_VALUE;
        for(int i = a.length-1;i>=0;i--){
            max = Math.max(max,a[i]);
            maxArr[i] = max;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int[] resultArr = new int[a.length];
        int index = 0;
        for(int i = 0;i < a.length;i++){
            stack.push(a[i]);
            while(!stack.isEmpty() && i < a.length -1 && stack.peek() > maxArr[i+1]){
                resultArr[index++] = stack.pop();
            }
        }
        while(!stack.isEmpty()){
            resultArr[index++] = stack.pop();
        }
        return resultArr;
    }
}
