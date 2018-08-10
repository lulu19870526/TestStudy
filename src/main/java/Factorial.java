/**
 * Created by zengqx on 2017/12/27.
 */
public class Factorial {

    public static void main(String[] args) {
        System.out.println("int的最大值为" + Integer.MAX_VALUE);
        int n = 12;
        int factorialSum = factorialRecursion(n);
        System.out.println("factorialSum=" + factorialSum + ";n=" + n);

        factorialFun(12);
        factorialFun(13);
    }

    public static int factorialRecursion(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorialRecursion(n - 1);
        }
    }

    public static void factorialFun(int n) {
        int[] array = new int[10000];
        array[0] = 1;
        int bit = 1;//代表阶乘值的位数
        int carry = 0;
        int i, j, k;
        for (i = 2; i <= n; i++) {//for循环，相关于递归,先计算i!,再计算(i+1)!,直至计算到所求的n!
            for (j = 0; j < bit; j++) {
                array[j] = array[j] * i;
            }

            for (j = 0; j < bit - 1; j++) {//从最低位array[0]开始直到array[bit-2],判断每一位是否有进位，如果有，则进行进位操作
                carry = array[j] / 10;//向下一位进位的值
                array[j] = array[j] % 10;
                k = j;
                array[++k] += carry;//加上进位的结果，
            }
            if (array[bit - 1] >= 10) {//判断最高为array[bit-1]的值是否大于0，如果大于0则进行进位操作
                int temp = array[bit - 1] / 10;
                array[bit - 1] = array[bit - 1] % 10;
                while (temp != 0) {
                    array[bit] = temp % 10;
                    temp = temp / 10;
                    bit++;//将最高位的结果依次进位，并增加响应阶乘结果的位数
                }
            }

        }
        for (i = bit - 1; i >= 0; i--) {//输出最终的值,从最高位array[bit-1]开始，直到array[0]
            System.out.print(array[i]);
        }
        System.out.println(" ,n=" + n);
    }
}
