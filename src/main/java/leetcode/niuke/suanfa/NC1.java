package leetcode.niuke.suanfa;

/**
 * @Author: zengqx
 * @Date: 2023/1/19 16:46
 */
public class NC1 {

    public static void main(String[] args){
        String result = solve("0","0");
        System.out.print("result="+result);
    }

    public static String solve (String s, String t) {
        if (s == null || s.length() == 0) {
            return t;
        } else if (t == null || t.length() == 0) {
            return s;
        }
        int idx = Math.max(s.length(), t.length()) - 1;
        int idx1 = s.length() - 1;
        int idx2 = t.length() - 1;
        int carry = 0;
        char[] arr = new char[idx + 1];
        while (idx1 >= 0 || idx2 >= 0) {
            int temp1 = idx1 >= 0 ? s.charAt(idx1--) - '0' : 0;
            int temp2 = idx2 >= 0 ? t.charAt(idx2--) - '0' : 0;
            int tempSum = temp1 + temp2 + carry;
            carry = tempSum / 10;
            arr[idx--] = (char)(tempSum % 10 + '0') ;
        }
        if (carry > 0) {
            return "1" + String.valueOf(arr);
        } else {
            return String.valueOf(arr);
        }
    }

}
