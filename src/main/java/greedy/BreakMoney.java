package greedy;

/**
 * 纸币找零问题
 *
 * 假设1元、2元、5元、10元、20元、50元、100元的纸币，
 * 张数不限制，现在要用来支付K元，至少要多少张纸币
 *
 *
 * 使用贪心算法来解决，并且我们所根据的贪心策略是，每一步尽可能用面值大的纸币即可
 */
public class BreakMoney {

    private static int[] moneyArr = {1,2,5,10,20,50,100};

    public static void main(String[] args){
        breakMoney(212);
    }
    public static void breakMoney(int k){
         for(int i= moneyArr.length-1;i>=0;i--){
             int tempCount = k/moneyArr[i];
              k= k % moneyArr[i];
              if(tempCount > 0){
                  System.out.println("面值为"+moneyArr[i]+"需要"+tempCount+"张");
              }
         }
    }
}
