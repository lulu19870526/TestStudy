package kmp;

/**
 * @Author: zengqx
 * @Date: 2023/1/28 13:39
 */
public class TestNextCnt {

    public static void main(String[] ags) {
        int result = kmp( "ababab","abababab");
        System.out.println("result=" + result);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 计算模板串S在文本串T中出现了多少次
     *
     * @param S string字符串 模板串
     * @param T string字符串 文本串
     * @return int整型
     */
    public static int kmp(String S, String T) {
        if (S == null || S.length() == 0 || T == null
                || T.length() == 0 || S.length() > T.length()) {
            return 0;
        }
        int[] next = next(S);
        int i = 0;
        int j = 0;
        int result = 0;
        while (i < T.length()) {
            if (j == -1 || T.charAt(i) == S.charAt(j)) {
                i++;
                j++;
                if (j == S.length()) {
                    result++;
                    j = next[j];
                }
            } else {
                j = next[j];
            }
        }
        return result;
    }

    private static int[] next(String s) {
        int[] next = new int[s.length() + 1];
        int k = -1;
        int j = 0;
        next[0] = -1;
        while (j < s.length()) {
            if (k == -1 ||s.charAt(j) == s.charAt(k)) {
                next[++j] = ++k;
            } else {
                k = next[k];
            }
        }
        return next;
    }
}
