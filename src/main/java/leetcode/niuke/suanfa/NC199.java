package leetcode.niuke.suanfa;

import java.util.Stack;

/**
 * @Author: zengqx
 * @Date: 2023/2/2 10:56
 */
public class NC199 {

    public static void main(String[] args){
        String result = decodeString("23[ab]");
        System.out.println(result);
        String str = "ababababababababababababababababababababababab";
        System.out.println(str.length());
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param s string字符串
     * @return string字符串
     */
    public static String decodeString (String s) {
        // write code here
        Stack<String> stack = new Stack<String>();
        StringBuffer strBuffer = new StringBuffer();
        StringBuffer numBuffer = new StringBuffer();
        StringBuffer finalBuffer = new StringBuffer();
        int sum = 0;
        String nums = "0123456789";
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) != ']'){
                stack.push(s.charAt(i) + "");
            }else{
                while(!stack.isEmpty() && !"[".equals(stack.peek())){
                    strBuffer.insert(0,stack.pop());
                }
                stack.pop();
                while(!stack.isEmpty() && nums.contains(stack.peek())){
                    numBuffer.insert(0,stack.pop());
                }
                sum = Integer.valueOf(numBuffer.toString());
                for(int j= 0;j < sum;j++){
                    finalBuffer.append(strBuffer.toString());
                }
                stack.push(finalBuffer.toString());
                strBuffer = new StringBuffer();
                numBuffer = new StringBuffer();
                finalBuffer = new StringBuffer();
                sum = 0;
            }
        }
        while(!stack.isEmpty()){
            finalBuffer.insert(0,stack.pop());
        }
        return finalBuffer.toString();
    }
}
