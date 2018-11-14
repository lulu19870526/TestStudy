package base.singleton;

//饿汉式(线程安全，调用效率高，但是不能延时加载)

public class Singleton1 {
    /**
     * 单例在还没有使用到的时候，初始化就已经完成了。
     * 也就是说，如果程序从头到位都没用使用这个单例的话，单例的对象还是会创建。
     * 这就造成了不必要的资源浪费
     */
    private static Singleton1 instance = new Singleton1();
    private Singleton1(){}
    public static Singleton1 getInstance(){
        return instance;
    }
}
