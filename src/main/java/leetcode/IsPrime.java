package leetcode;

/**
 * 质数（prime number）又称素数，有无限个。
 * 质数定义为在大于1的自然数中，除了1和它本身以外不再有其他因数。
 */
public class IsPrime {

    public static void main(String[] args){
        int count = countPrimes(10);
        System.out.println("count="+count);
    }

    public static int countPrimes(int n) {
        int count = 0;
        for(int i = 2;i< n;i++){
            if(isPrime(i) == true)
                count ++;
        }
        return count;
    }

    public static boolean isPrime(int number){
        for(int i = 2; i < number;i++){
            if(number % i  == 0)
                return false;
        }
        return true;
    }
}
