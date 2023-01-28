package leetcode.niuke.suanfa;

/**
 * @Author: zengqx
 * @Date: 2023/1/20 10:34
 */
public class NC10 {

    public static void main(String[] args){
        String result = solve("733064366","459309139");
        //String result = solve1("733064366","459309139");
        System.out.print(result);
    }
    public static String solve (String s, String t) {
        // write code here
        if(s == null || s.length() == 0 || t == null || t.length() == 0){
            return null;
        }
        if("0".equals(s) || "0".equals(t)){
            return "0";
        }
        int zero = 0;
        String result = "0";
        for(int i = t.length()-1;i>=0;i--){
            StringBuilder temp = new StringBuilder();
            int carry = 0;
            int first = t.charAt(i) - '0';
            for(int k = 0;k < zero;k++){
                temp.append("0");
            }
            zero++;
            for(int j = s.length()-1;j >= 0;j--){
                int second = s.charAt(j) - '0';
                int sum = first * second + carry;
                temp.append(sum % 10);
                carry = sum / 10;
            }
            if(carry != 0){
                temp.append(carry);
            }
            result = add(result,temp.reverse().toString());
        }
        return result;
    }

    private static String add(String num1,String num2){
        System.out.println("num1="+num1+";num2="+num2);
        if(num1 == null){
            return num2;
        }else if(num2 == null){
            return num1;
        }
        int idx = Math.max(num1.length(),num2.length()) - 1;
        int idx1 = num1.length() - 1;
        int idx2 = num2.length() - 1;
        int carry = 0;
        char[] arr = new char[idx + 1];
        while(idx1 >= 0 || idx2 >= 0){
            int first = idx1 >= 0 ?num1.charAt(idx1--) - '0':0;
            int second = idx2 >= 0?num2.charAt(idx2--) - '0':0;
            int sum = first + second + carry;
            arr[idx--] =(char)(sum % 10 + '0');
            carry = sum /10;
        }
        if(carry == 1){
            return "1" + String.valueOf(arr);
        }else{
            return String.valueOf(arr);
        }

    }



    public static String solve1 (String num1, String num2) {
        // 判断不合法的输入
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) {
            return null;
        }
        // 如果 num1 或 num2 其中有一个为 0， 则最后相乘的结果为 0
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        // 最后的结果
        String res = "0";
        // 相乘之后，后面需要补零的个数
        int zero = 0;
        // 从右往左遍历 num2 字符串中的每一个数字， 使其和 num1 字符串相乘， 再相加，即得最后结果
        for (int i = chars2.length - 1; i >= 0; i--) {
            // 每一个数字和 num1 字符串相乘的结果
            StringBuilder temp = new StringBuilder();
            // 保存进位
            int carry = 0;

            // 将后面需要的零补齐
            for (int j = 0; j < zero; j++) {
                temp.append('0');
            }
            zero++;

            // 取出 num2 字符串的每一个数字， 记为 y
            int y = chars2[i] - '0';
            // 使 y 和 num1 字符串相乘
            for (int j = chars1.length - 1; j >= 0; j--) {
                int x = chars1[j] - '0';
                int num = x * y + carry;
                temp.append(num % 10);
                carry = num / 10;
            }
            // 如果最后进位不为 0 ， 则还需要往前进 carry 位
            if (carry != 0) {
                temp.append(carry);
            }
            // 把每次相乘的结果相加起来，就是最后的结果
            res = bigNumberAdd(res, temp.reverse().toString());
        }
        return res;
    }

    /**
     *
     * @param num1 第一个数字字符串
     * @param num2 第二个数字字符串
     * @return  两个字符串相加之后的结果
     */
    public static String bigNumberAdd(String num1, String num2) {
        System.out.println("num1="+num1+";num2="+num2);
        // 判断不合法输入
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) {
            return null;
        }
        // num1 字符串的下标， 从右往左遍历
        int index1 = num1.length() - 1;
        // num2 字符串的下标， 从右往左遍历
        int index2 = num2.length() - 1;

        // 最后相加的结果
        StringBuilder res = new StringBuilder();
        // 保存进位
        int carry = 0;

        // num1 或 num2 只要有一个字符串还有值，就继续循环
        while (index1 >= 0 || index2 >= 0) {
            // 拿到 num1 的一个数字
            int x = index1 >= 0 ? num1.charAt(index1--) - '0' : 0;
            // 拿到 num2 的一个数字
            int y = index2 >= 0 ? num2.charAt(index2--) - '0' : 0;
            // 拿到的 2 个数字相加，要考虑进位的情况
            int num = x + y + carry;
            // 该位只保存个位数
            res.append(num % 10);
            // 十位数要往前进一位
            carry = num / 10;
        }
        // 如果最后进位不为 0 ， 则还需要往前进 carry 位
        if (carry != 0) {
            res.append(carry);
        }
        return res.reverse().toString();
    }
}
