package base.singleton;

/**
 * 创建枚举默认就是线程安全的，
 * 所以不需要担心double checked locking，而且还能防止反射和防止反序列化导致重新创建新的对象。
 */
public enum Singleton {
    Instance;

    public void anyMethod(){}
}

class TestSingleton{
    public static void main(String[] args){
        Singleton singleton1 = Singleton.Instance;
        Singleton singleton2 = Singleton.Instance;
        System.out.println(singleton1 == singleton2);//true
    }
}
