package algorithm;


//牛顿迭代法x(n+1)=x(n)－f(x(n))/f'(x(n))
public class Sqrt {

    public static double sqrt(double n){
        double k=1.0;
        while(Math.abs(k*k-n)>1e-9) {
            k=(k+n/k)/2;
        }
        return k;

    }

    public static void main(String[] args){
        double sqrt1 = sqrt(5);
        System.out.println("sqrt1="+sqrt1);
        double sqrt2 = sqrt(9);
        System.out.println("sqrt2="+sqrt2);
    }

}
