package algorithm;

//给定一个数，如何求它的平方根(不能使用内置函数，如sqrt()函数)。
public class Sqrt1 {

    public static void main(String[] args){
        double sqrt1 = sqrt(5);
        System.out.println("sqrt1="+sqrt1);
        double sqrt2 = sqrt(9);
        System.out.println("sqrt2="+sqrt2);
    }

    /*
    二分法，这是比较容易想到的一种方法。通过比较中间值与最终值的大小来改变中间值，
    最终在满足某个精度的情况下返回这个中间值作为最终结果
     */
    static double sqrt(float x){
        double max = x;
        double min = 0;
        double mid=(min+max)/2;
        while (true){
            if (Math.abs(x-mid*mid)<1e-9) return mid;

            if(mid*mid>x)
            {
                max=mid;
            }
            else if(mid*mid<x)
            {
                min=mid;
            }

            mid=(min+max)/2;
        }


    }

}
