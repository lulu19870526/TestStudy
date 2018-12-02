package study;

public class IntegerSwap {

    public static void main(String[] args){
        Integer mainA = 3;
        Integer mainB = 5;
        System.out.println("交换前,mainA="+mainA+";mainB="+mainB);
        swap(mainA,mainB);
        System.out.println("交换后,mainA="+mainA+";mainB="+mainB);

        Integer mainC = 300;
        Integer mainD = 500;
        System.out.println("交换前,mainC="+mainC+";mainD="+mainD);
        swap(mainC,mainD);
        System.out.println("交换后,mainC="+mainC+";mainD="+mainD);
    }

    /**
     * 对象类型的传参，传递的是堆上的地址，
     * 在方法内部是有一个新的局部变量得到引用地址的拷贝，对该局部变量的操作，影响的是同一块地址，因此原本的参数也会受影响，
     * 反之，若修改局部变量的引用地址，则不会对原本的参数产生任何可能的影响。
     */
    private static void swap(Integer a,Integer b){
        Integer temp = a;
        a = b;
        b = temp;
    }

}
