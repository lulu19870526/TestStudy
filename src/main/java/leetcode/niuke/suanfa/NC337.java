package leetcode.niuke.suanfa;

/**
 * @Author: zengqx
 * @Date: 2023/2/17 19:20
 */
public class NC337 {
    public static void main(String[] args){
        String result = IPtoNum("118.90.46.99");
        System.out.println(result);
        String str = intToBinary(1985621603);
        System.out.println(str);
        int num = Integer.parseInt("1110110010110100010111001100011",2);
        System.out.println(num);
        System.out.println();

    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param ip string字符串
     * @return string字符串
     */
    public static String IPtoNum (String ip) {
        // write code here
        String[] arr = ip.split("\\.");
        StringBuilder strBuilder = new StringBuilder();
        for(int i = 0;i < arr.length;i++){
            String temp = intToBinary(Integer.parseInt(arr[i]));
            strBuilder.append(temp);
        }
        char[] binaryArr = strBuilder.toString().toCharArray();
        long result = 0l;
        for(int i = 0; i < binaryArr.length;i++){
            result = result * 2 + (binaryArr[i] - '0');
        }
        return String.valueOf(result);
    }

    private static String intToBinary(int num){
        int num1 = num;
        StringBuilder strBuilder = new StringBuilder();
        while(num != 0){
            strBuilder.append(num % 2);
            num = num / 2;
        }
        String result = strBuilder.reverse().toString();
        int len = result.length();
        for(int i = 0; i < (8 - len);i++){
            result = "0" + result;
        }
        System.out.println("num="+num1+";result="+result);
        return result;
    }
}
