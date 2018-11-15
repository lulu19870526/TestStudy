package base.singleton;

//静态内部类实现模式（线程安全，调用效率高，可以延时加载）
public class Singleton4 {

    //静态内部类
    private static class SingletonClassInstance{
        private static final Singleton4 instance=new Singleton4();
    }

    private Singleton4(){}

    public static Singleton4 getInstance(){
        /**
         *  静态内部类和非静态内部类一样，都是在被调用时才会被加载
         *   静态内部类其实和外部类的静态变量，静态方法一样，只要被调用了都会让外部类的被加载。
         *   不过当只调用外部类的静态变量，静态方法时，是不会让静态内部类的被加载
         */
        return SingletonClassInstance.instance;
    }


}
