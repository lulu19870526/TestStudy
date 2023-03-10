package leetcode.niuke.suanfa;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zengqx
 * @Date: 2023/3/8 13:18
 */
public class NC255 {

    public static void main(String[] args){
        String[] arr = maxValidParenthesesStr(")(w");
        System.out.println(arr);
    }


    private static List<String> res = new ArrayList<String>();
    private static List<String> ans= new ArrayList<String>();
    public static String[] maxValidParenthesesStr(String s) {
        int lremove = 0;
        int rremove = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                lremove++;
            } else if (s.charAt(i) == ')') {
                if (lremove == 0) {
                    rremove++;
                } else {
                    lremove--;
                }
            }
        }
        helper(s, 0, lremove, rremove);
        String[] strings = new String[res.size()];
        return res.toArray(strings);
    }

    private static void helper(String str, int start, int lremove, int rremove) {
        if (lremove == 0 && rremove == 0) {
            if (isValid(str)) {
                res.add(str);
            }
            return;
        }

        for (int i = start; i < str.length(); i++) {
            if (i != start && str.charAt(i) == str.charAt(i - 1)) {
                continue;
            }
            // 如果剩余的字符无法满足去掉的数量要求，直接返回
            if (lremove + rremove > str.length() - i) {
                return;
            }
            // 尝试去掉一个左括号
            if (lremove > 0 && str.charAt(i) == '(') {
                helper(str.substring(0, i) + str.substring(i + 1), i, lremove - 1, rremove);
            }
            // 尝试去掉一个右括号
            if (rremove > 0 && str.charAt(i) == ')') {
                helper(str.substring(0, i) + str.substring(i + 1), i, lremove, rremove - 1);
            }
        }
    }

    private static boolean isValid(String str) {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                cnt++;
            } else if (str.charAt(i) == ')') {
                cnt--;
                if (cnt < 0) {
                    return false;
                }
            }
        }
        return cnt == 0;
    }
}
