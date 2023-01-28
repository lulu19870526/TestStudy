package leetcode.niuke.suanfa;

import java.util.Stack;

/**
 * @Author: zengqx
 * @Date: 2022/11/26 22:09
 */
public class Solution {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();

    public void push(int node) {
        stack.push(node);
        if(minStack.isEmpty() || node <= minStack.peek()){
            minStack.push(node);
        }else{
            minStack.push(minStack.peek());
        }
    }

    public void pop() {

        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }

    public static void main(String[] arge){
        Solution solution = new Solution();
        solution.push(9);
        solution.push(1);
        solution.push(6);
        int min = solution.min();
        System.out.println("min:"+min);
        solution.pop();
        solution.pop();
        int min1 = solution.min();
        System.out.println("min1:"+min1);
    }
}
