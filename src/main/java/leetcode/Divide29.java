package leetcode;


/**
 * 这道题让我们求两数相除，而且规定我们不能用乘法，除法和取余操作，
 * 那么我们还可以用另一神器位操作Bit Operation，思路是，如果被除数大于或等于除数，
 * 则进行如下循环，定义变量t等于除数，定义计数p，当t的两倍小于等于被除数时，
 * 进行如下循环，t扩大一倍，p扩大一倍，然后更新res和m。
 * 这道题的OJ给的一些test case非常的讨厌，因为输入的都是int型，比如被除数是-2147483648，
 * 在int范围内，当除数是-1时，结果就超出了int范围，需要返回INT_MAX，
 * 所以对于这种情况我们就在开始用if判定，将其和除数为0的情况放一起判定，
 * 返回INT_MAX。然后我们还要根据被除数和除数的正负来确定返回值的正负，
 * 这里我们采用长整型long来完成所有的计算，最后返回值乘以符号即可
 */
public class Divide29 {

    public static void main(String[] args){
        int a = divide(-1,1);
        System.out.println("a="+a);
        System.out.println("max="+Integer.MAX_VALUE);
    }

    public static int divide(int dividend, int divisor) {
        if(divisor == 0 ||
                (dividend == Integer.MAX_VALUE && divisor == -1))
            return Integer.MAX_VALUE;

        int sign = (dividend > 0)^(divisor >0)?-1 :1;

        long a = (long)Math.abs(dividend);
        long b = (long)Math.abs(divisor);

        int result=0;
        while(a >= b){
            long sum = b;
            int pow = 1;
            while(sum << 1 <= a){
                sum = sum << 1;
                pow = pow << 1;
            }
            a -= sum;
            result += pow;
        }

        return sign == 1 ? result :-result;
    }
}
