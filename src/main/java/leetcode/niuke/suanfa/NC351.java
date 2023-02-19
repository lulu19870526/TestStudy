package leetcode.niuke.suanfa;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zengqx
 * @Date: 2023/2/19 12:35
 */
public class NC351 {

    public static void main(String[] args){
        String result = frac2Dec(1,-1073741824);
        System.out.println(result);
    }


    /**
     *
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param n int整型
     * @param m int整型
     * @return string字符串
     */
    public static String frac2Dec (int n, int m) {
        // write code here
        StringBuilder strBuilder = new StringBuilder();
        if( (n < 0 && m > 0) || (n > 0 && m < 0 )){
            strBuilder.append("-");
        }
        long a = Math.abs(n);
        long b = Math.abs(m);
        strBuilder.append(a/b);
        strBuilder.append(".");
        Map<Long,Integer> map = new HashMap<>();
        while((a= ((a % b) * 10)) != 0){
            strBuilder.append(a / b);
            if(map.containsKey(a)){
                return strBuilder.substring(0,map.get(a)) +"(" + strBuilder.substring(map.get(a) ,strBuilder.length() - 1)+")";
            }
            map.put(a,strBuilder.length() - 1);
        }
        return (strBuilder.charAt(strBuilder.length()  -1) == '.') ?strBuilder.substring(0,strBuilder.length() -1) : strBuilder.toString();
    }
}
