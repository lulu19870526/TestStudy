package kmp;

/**
 * @Author: zengqx
 * @Date: 2023/1/28 12:39
 */
public class Test1 {

    public static void main(String[] ags) {
        int result = kmp("abacabab", "abab");
        System.out.println("result=" + result);
    }


    private static int kmp(String s, String p) {
        if (s == null || s.length() == 0 || p == null
                || p.length() == 0 || p.length() > s.length()) {
            return -1;
        }
        int i = 0;
        int j = 0;
        while (i < s.length() && j < p.length()) {
            if (s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == p.length()) {
            return i - j;
        } else {
            return -1;
        }
    }

}
