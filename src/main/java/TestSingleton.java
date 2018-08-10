/**
 * Created by zengqx on 2017/12/18.
 */
public class TestSingleton {

    private static TestSingleton instance;

    private TestSingleton() {
        System.out.println("调用TestSingleton类的构造函数");
    }

    public static TestSingleton getInstance() {
        if (instance == null) {
            synchronized (TestSingleton.class) {
                if (instance == null) {
                    instance = new TestSingleton();
                }
            }
        }
        return instance;
    }

    public static void  fun(){
        System.out.println("调用TestSingleton类的fun()函数");
    }
}

class MyThread implements Runnable {

    public void run() {
        System.out.println("hashCode值为" + TestSingleton.getInstance().hashCode());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new MyThread());
            thread.start();
        }
    }
}
