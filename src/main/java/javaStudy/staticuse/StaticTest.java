package javaStudy.staticuse;


/**
 * 静态变量的声明、静态代码块
 * Java虚拟机会按照它们在类文件中的先后顺序来依次执行它们
 */
public class StaticTest {
    private static int a = 1;
    static{
        a = 2;
    }
    static{
        a = 4;
    }
    public static void main(String[] args){
        System.out.println("a:" + a);//值为4
    }
}
