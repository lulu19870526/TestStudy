package javaStudy.load;


/**
 * 没有继承情况下
 *
 * 1. 执行顺序
 *     1. 静态成员变量
 *     2. 静态代码块
 *     3. 普通成员变量
 *     4. 普通代码块
 *     5. 构造函数
 *
 * 2. 总结：
 *
 *         1. 静态->普通
 *         2. 变量->代码块->构造函数
 *         3. 构造函数是最后执行的
 */
public class Father {
    private static String name = "zct";
    private int age = 50;

    {
        System.out.println("father age: "+age);
        System.out.println("father 我是普通代码块");
    }

    static{
        System.out.println("father static name: "+name);
        System.out.println("father 我是静态代码块");
    }

    public Father(){
        System.out.println("father 我是构造函数");
    }

    public static void main(String[] args){
        Father father = new Father();
    }
}
