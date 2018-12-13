package leetcode;


/**
 * 将一个数字的每个位上的数字分别存到一个一维向量中，
 * 最高位在最开头，我们需要给这个数字加一，即在末尾数字加一，
 * 如果末尾数字是9，那么则会有进位问题，而如果前面位上的数字仍为9，则需要继续向前进位。
 * 具体算法如下：首先判断最后一位是否为9，若不是，直接加一返回，
 * 若是，则该位赋0，再继续查前一位，同样的方法，知道查完第一位。
 * 如果第一位原本为9，加一后会产生新的一位，
 * 那么最后要做的是，查运算完的第一位是否为0，如果是，则在最前头加一个1。
 */
public class PlusOne66 {

    public static void main(String[] args){
        //int[] a = {9,9,9};
        int[] a = {1,2,8,7};
        int[] result = plusOne(a);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+"   ");
        }
    }

    public static int[] plusOne(int[] digits) {
        for(int i = digits.length-1;i >=0;i--){
            if(digits[i] < 9){
                digits[i] ++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] result = new int[digits.length+1];
        result[0] = 1;
        for(int j = 0;j<digits.length;j++){
            result[j+1] = digits[j];
        }
        return result;
    }
}
