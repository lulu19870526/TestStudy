package javaStudy.string;

/**
 * 1.String str=“abc”和String str=new String(“abc”); 产生几个对象？
 *      前者1或0，后者2或1，先看字符串常量池，如果字符串常量池中没有，都在常量池中创建一个，
 * 如果有，前者直接引用，后者在堆内存中还需创建一个“abc”实例对象。
 *2.对于基础类型的变量和常量：变量和引用存储在栈中，常量存储在常量池中。
 * 3.为了提升jvm（JAVA虚拟机）性能和减少内存开销，避免字符的重复创建 项目中还是不要使用new String去创建字符串，最好使用String直接赋值。
 *4.关于equals()和==:对于String类简单来说，equals()就是比较两字符串的内容是否相等，如果相等返回true;
 * 而==是比较两字符串的地址是否相同，也就是是否是同一个字符串的引用，如果是返回true。
 *5.String字符串是不可变的。
 */
public class Test {

    public static void main(String[] args){
        /**
         * String str = “abc”：可能创建一个或者不创建对象。
         * 如果”abc”在字符串池中不存在，会在java字符串池中创建一个String对象（”abc”），
         * 然后str指向这个内存地址，无论以后用这种方式创建多少个值为”abc”的字符串对象，
         * 始终只有一个内存地址被分配；如果“abc” 在字符串池中存在, str直接指向这个内存地址。
         */
        String str = "abc";
        String str1 = "abc";
        String str2 = "abc";
        System.out.println(str==str1);//true
        System.out.println(str==str2);//true


        /**
         * String str = new String(“abc”)：至少会创建一个对象，也有可能创建两个。
         * 因为用到new关键字，肯定会在堆中创建一个String对象，如果字符池中已经存在”abc”,
         * 则不会在字符串池中创建一个String对象，如果不存在，则会在字符串常量池中也创建一个对象。
         */
        String str3 = new String("abc");
        String str4 = new String("abc");
        String str5 = new String("abc");
        System.out.println(str3==str4);//false
        System.out.println(str3==str5);//false


        /**
         * String拼接字符串：
         * 除了直接使用=赋值，也会用到字符串拼接，字符串拼接又分为变量拼接和已知字符串拼接。
         * 只要拼接内容存在变量，那么该拼接后的新变量就是在堆内存中新建的一个对象实体。
         */
        String str6 = "abc";//在常量池中创建abc
        String str7 = "abcd";//在常量池中创建abcd
        String str8 = str6+"d";//拼接字符串，此时会在堆中新建一个abcd的对象，因为str6编译之前是未知的
        String str9 = "abc"+"d";//拼接之后str3还是abcd，所以还是会指向字符串常量池的内存地址
        System.out.println(str7==str8);//false
        System.out.println(str7==str9);//true

        /**
         * String.intern()：一个字符串，内容与此字符串相同，但一定取自具有唯一字符串的池
         *        当调用 intern 方法时，如果常量池已经包含一个等于此 String 对象的字符串（用 equals(Object) 方法确定），
         * 则返回池中的字符串。否则，将此 String 对象添加到常量池中，并返回此 String 对象的引用。
         */
        String s1=new String("abc");
        String s2=s1.intern();
        System.out.println( s1==s2 ); //false
        System.out.println( s1+" "+s2 ); // abc abc
        System.out.println( s2==s1.intern() ); //true

    }
}
