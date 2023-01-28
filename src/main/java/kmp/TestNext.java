package kmp;

/**
 * @Author: zengqx
 * @Date: 2023/1/28 12:48
 */
public class TestNext {

    public static void main(String[] ags) {
        int result = kmp("abacabab", "abab");
        System.out.println("result=" + result);
    }

    private static int kmp(String s, String p) {
        if (s == null || s.length() == 0 || p == null
                || p.length() == 0 || p.length() > s.length()) {
            return -1;
        }
        int[] next = next(p);
        int i = 0;
        int j = 0;
        while (i < s.length() && j < p.length()) {
            if (j == -1 || s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == p.length()) {
            return i - j;
        } else {
            return -1;
        }
    }

    private static int[] next(String p) {
        int[] next = new int[p.length()];
        next[0] = -1;
        int j = 0;
        int k = -1;
        while (j < p.length() - 1) {
            if (k == -1 || p.charAt(j) == p.charAt(k)) {
                next[++j] = ++k;
            } else {
                k = next[k];
            }
        }
        return next;
    }
}
