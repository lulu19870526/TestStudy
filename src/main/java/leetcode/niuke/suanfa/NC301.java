package leetcode.niuke.suanfa;

/**
 * @Author: zengqx
 * @Date: 2023/2/16 20:31
 */
public class NC301 {

    public static void main(String[] args){
        /**
        String result = maximumSwap("4321");
        System.out.println(result);
        String result1 = maximumSwap("4556");
        System.out.println(result1);
        String result2 = maximumSwap("5");
        System.out.println(result2);
        String result3 = maximumSwap("8873");
        System.out.println(result3);
         */
        String result = maximumSwap1("4321");
        System.out.println(result);
        String result1 = maximumSwap1("4556");
        System.out.println(result1);
        String result2 = maximumSwap1("5");
        System.out.println(result2);
        String result3 = maximumSwap1("8873");
        System.out.println(result3);
    }


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param num string字符串
     * @return string字符串
     */
    public static String maximumSwap (String num) {
        // write code here
        char[] chars = num.toCharArray();
        int maxIndex = 0;
        int max = '0';
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] > max) {
                max = chars[i];
                maxIndex = i;
            }
        }
        int targetIndex = -1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == max) {
                targetIndex = i;
            } else {
                break;
            }
        }
        if (targetIndex == chars.length - 1) {
            return num;
        }
        targetIndex++;
        if (maxIndex != targetIndex && targetIndex < maxIndex) {
            char temp = chars[targetIndex];
            chars[targetIndex] = chars[maxIndex];
            chars[maxIndex] = temp;
        }
        return new String(chars);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param num string字符串
     * @return string字符串
     */
    public static String maximumSwap1 (String num) {
        // write code here
        char[] arr = num.toCharArray();
        char max = '0';
        int maxIndex = 0;
        for (int i = num.length() - 1; i >= 0; i--) {
            if (num.charAt(i) > max) {
                max = num.charAt(i);
                maxIndex = i;
            }
        }
        int index = -1;
        for(int i = 0;i < num.length();i++){
            if(num.charAt(i) == max){
                index = i;
            }else{
                break;
            }
        }
        if(index == (num.length() - 1)){
            return num;
        }
        index++;
        if(index != maxIndex && index < maxIndex){
            char temp = arr[index];
            arr[index] = arr[maxIndex];
            arr[maxIndex] = temp;
        }
        return new String(arr);
    }
}
