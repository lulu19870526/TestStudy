package leetcode;

import java.util.Stack;


/**
 * 验证输入的字符串是否为括号字符串，包括大括号，中括号和小括号。
 * 这里我们需要用一个栈，我们开始遍历输入字符串，如果当前字符为左半边括号时，
 * 则将其压入栈中，如果遇到右半边括号时，若此时栈为空，则直接返回false，
 * 如不为空，则取出栈顶元素，若为对应的左半边括号，则继续循环，反之返回false
 */
public class ValidKuohao20 {

    public static void main(String[] args){
        boolean b = isValid("()");
        System.out.println("b="+b);
    }

    public static  boolean isValid(String s) {
        Stack<String> stack = new Stack<String>();
        if(s != null && s.length() != 0){
            for(int i=0;i<s.length();i++){
                char temp = s.charAt(i);
                if(temp == '(' || temp == '[' || temp == '{')
                    stack.push(temp+"");
                else{
                    if(stack.empty())
                        return false;
                    if(temp == ')' && !stack.peek().equals( "("))
                        return false;
                    if(temp == ']' && stack.peek().equals("["))
                        return false;
                    if(temp == '}' && stack.peek() .equals( "{"))
                        return false;

                    stack.pop();
                }
            }

            return stack.empty();
        }else{
            return true;
        }
    }
}
