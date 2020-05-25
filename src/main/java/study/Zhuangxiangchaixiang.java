package study;

/**
 * 装箱是通过调用包装器类的 valueOf 方法实现的
 * 拆箱是通过调用包装器类的 xxxValue 方法实现的，
 * xxx代表对应的基本数据类型(int,short,long,double,byte,char,float,boolean)
 *
 * Integer派别：Integer、Short、Byte、Character、Long这几个类的valueOf方法的实现是类似的。 
 * Double派别：Double、Float的valueOf方法的实现是类似的。每次都返回不同的对象。
 *
 * Created by zengqx on 2018/7/12.
 */
public class Zhuangxiangchaixiang {

    public static void main(String[] args) {

        /**
         * Integer的valueOf
         * 1、i >= 128 || i < -128 =====> new Integer(i) 
         * 2、i < 128 && i >= -128 =====> SMALL_VALUES[i + 128]
         *
         * 值在[-128,127]这个范围内，它们会拿到SMALL_VALUES数组里面的同一个对象SMALL_VALUES[228]，
         * 它们引用到了同一个Integer对象，所以它们肯定是相等的。
         */
        Integer i1 = -128;
        Integer i2 = -128;
        Integer i3 = 127;
        Integer i4 = 127;
        System.out.println("i1==i2:"+ (i1==i2));  //true
        System.out.println("i3==i4:"+(i3==i4));  //true
        Integer i5 = -129;
        Integer i6 = -129;
        Integer i7 = 128;
        Integer i8 = 128;
        System.out.println("i5==i6:"+ (i5==i6));  //false
        System.out.println("i7==i8:"+(i7==i8));  //false

        /**
         *Double的valueOf里面的做法很直接，就是直接创建一个对象，所以每次创建的对象都不一样。
         */
        Double d1 = 100.0;
        Double d2 = 100.0;
        Double d3 = 200.0;
        Double d4 = 200.0;
        System.out.println("d1==d2:"+ (d1==d2));  //false
        System.out.println("d3==d4:"+ (d3==d4));  //false

        /**
         * public static Boolean valueOf(boolean b) {
         *         return (b ? TRUE : FALSE);
         *     }
         *     Boolean TRUE = new Boolean(true)
         *     Boolean FALSE = new Boolean(false)
         *
         *  valueOf返回的都是相同的对象,因为在内部已经提前创建好两个对象，
         *  因为它只有两种情况，这样也是为了避免重复创建太多的对象。
         */
        Boolean b1 = true;
        Boolean b2 = true;
        Boolean b3 = false;
        Boolean b4 = false;
        System.out.println("b1==b2:"+ (b1==b2));  //true
        System.out.println("b3==b4:"+ (b3==b4));  //true


        Integer a1 = 400;
        int a2 = 400;
        Long a3 = 800l;
        /**
         * 当一个基础数据类型与封装类进行==、+、-、*、/运算时，会将封装类进行拆箱，
         * 对基础数据类型进行运算
         */
        System.out.println("a1==a2:"+ (a1==a2));  //true
        System.out.println("a3==(a1 + a2):"+ (a3==(a1 + a2)));  //true

        /**
         *  public boolean equals(Object obj) {
         *         if (obj instanceof Integer) {
         *             return value == ((Integer)obj).intValue();
         *         }
         *         return false;
         *     }
         *     equal的参数是一个Object对象，我们传入的是一个int类型，所以首先会进行装箱，然后比较，
         *     之所以返回true，是由于它比较的是对象里面的value值
         */
        System.out.println("a1.equals(a2)"+ (a1.equals(a2)));//true

        /**
         *public boolean equals(Object obj) {
         *         if (obj instanceof Long) {
         *             return value == ((Long)obj).longValue();
         *         }
         *         return false;
         *     }
         *     返回false的原因就是类型不同
         */
        System.out.println("a3.equals(a1 + a2):"+ (a3.equals(a1 + a2)));  //false


        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        Long h = 2L;

        /**
         * Integer值在[-128,127]这个范围内,不用创建新对象，用缓存中已有的
         */
        System.out.println(c==d);  //true
        System.out.println(e==f);  //false

        /**
         * 当 “==”运算符的两个操作数都是 包装器类型的引用，则是比较指向的是否是同一个对象，
         * 而如果其中有一个操作数是表达式（即包含算术运算）则比较的是数值（即会触发自动拆箱的过程）。
         */
        System.out.println(c==(a+b));  //true
        System.out.println(c.equals(a+b));//true
        /**
         * 当 “==”运算符的两个操作数都是 包装器类型的引用，则是比较指向的是否是同一个对象，
         * 而如果其中有一个操作数是表达式（即包含算术运算）则比较的是数值（即会触发自动拆箱的过程）。
         */
        System.out.println(g==(a+b));  //true
        System.out.println(g.equals(a+b));//false
        System.out.println(g.equals(a+h));//true
    }
}
