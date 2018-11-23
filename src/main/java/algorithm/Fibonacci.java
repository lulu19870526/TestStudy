package algorithm;

public class Fibonacci {

    public static void main(String args[]){
        for(int i = 0 ;i< 10;i++){
            System.out.println("f("+i+")=" + fibonacciFun(i));
        }
    }

    public static long fibonacciFun(int n){
        if(n < 0){
            return -1l;
        }else if(n == 0 || n == 1){
            return n;
        }else{
            long lastOne = 1;
            long lastTwo = 0;
            long lastN = 0;
            for(int i = 2 ;i <= n ;i++){
                lastN = lastOne + lastTwo;
                lastTwo = lastOne;
                lastOne = lastN;
            }
            return lastN;
        }
    }
}
