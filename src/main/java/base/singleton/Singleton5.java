package base.singleton;


import java.io.*;

/**
 * @Author: zengqx
 * @Date: 2023/7/27 15:48
 */
public class Singleton5 implements Serializable {

    private static Singleton5 instance = new Singleton5();

    private Singleton5() {
    }

    public static Singleton5 getInstance() {
        return instance;
    }

    /**
     * 如何阻止反序列化破坏单例
     * 实现一个 readResolve 方法，该方法直接返回了这个单例对象：
     */
    private Object readResolve(){
        return instance;
    }

    public static void main(String args[]){
        Singleton5 instance1 = Singleton5.getInstance();
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(
                    "D:\\testSingleton.txt"));
            oos.writeObject(instance1);

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\testSingleton.txt"));
            Singleton5 instance2 = (Singleton5)ois.readObject();
            /**
             * 结果为 false(readResolve方法注释掉），
             * 说明通过对 Singleton 的序列化再反序列化得到的对象是一个新的对象，这就破坏了 Singleton 的单例性。
             */
            System.out.println(instance1 == instance2);

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
