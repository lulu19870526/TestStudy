package javaStudy.load;

/**
 * 子类继承父类的情况下
 *
 * 1. 执行顺序
 *     1. 父类的静态成员变量
 *     2. 父类的静态代码块
 *     3. 子类的静态成员变量
 *     4. 子类的静态代码块
 *     5. 父类的成员变量
 *     6. 父类的代码块
 *     7. 父类的构造函数
 *     8. 子类的成员变量
 *     9. 子类的代码块
 *     10. 子类的构造函数
 *
 * 2. 总结：
 *     1. 先父类再子类
 *     2. 如果子类有静态成员变量和静态代码块，则执行完父类的静态成员变量和静态代码块后，接着执行子类的静态变量和静态代码块，
 *     否则直接按照父类的变量->代码块->构造函数，再执行子类的变量->代码块->构造函数
 *     3. 需要注意的是子类的静态变量和静态代码块是优先于父类的普通成员变量和代码块以及构造函数的。
 *     4. 这也说明了先静态->再普通
 */
public class Son  extends Father{

    private static String name = "zlc";
    private int age = 26;
    {
        System.out.println("son age: "+age);
        System.out.println("son 我是普通代码块");
    }

    static{
        System.out.println("son static name: "+name);
        System.out.println("son 我是静态代码块");
    }

    public Son(){
        System.out.println("son 我是构造函数");
    }

    public static void main(String[] args){
        Son son = new Son();
    }
}

