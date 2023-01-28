package leetcode.niuke.suanfa;

/**
 * @Author: zengqx
 * @Date: 2023/1/19 8:47
 */
public class NC371 {

    public static void main(String[] args){
        //boolean flag = palindrome("12345678765321");
        //boolean flag = validPalindrome("12345678765321");
        boolean flag = palindrome("12345678765321");
        System.out.print(flag);
    }

   static boolean isDel = false;
    public static boolean palindrome (String str) {

        if (null == str) {
            return false;
        }
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) == str.charAt(right)) {
                left++;
                right--;
            } else {
                if (isDel) { // 已经删除过一个字符，又遇到了不对称的地方，不满足回文，直接返回false；
                    return false;
                }
                isDel = true;
                boolean b1 = palindrome(str.substring(left, right));
                boolean b2 = palindrome(str.substring(left + 1, right + 1));
                return b1 || b2;
            }
        }
        return true;
    }

    /**
    public static boolean palindrome (String str) {
        char[] nums = str.toCharArray();
        int start = 0;
        int end = nums.length - 1;
        int count = 0;
        while (start < end) {
            if (nums[start] != nums[end]) {
                count++;
            }
            start++;
            end--;
            if (count>1){
                return false;
            }

        }
        return  true;
    }

    public static boolean validPalindrome(String s) {
        int l = s.length();
        char cs[] = s.toCharArray();
        int i=0,j=l-1;

        while (i<=j) {
            if(cs[i]!=cs[j]) {
                break;
            }
            i++;
            j--;
        }
        if(i>=j) return true;
        return isPalindrome(cs, i+1, j) || isPalindrome(cs, i, j-1);
    }

    public static boolean isPalindrome(char[] cs, int i, int j) {
        while (i<j) {
            if(cs[i]!=cs[j])
                return false;
            i++;
            j--;
        }
        return true;
    }
     */
}
