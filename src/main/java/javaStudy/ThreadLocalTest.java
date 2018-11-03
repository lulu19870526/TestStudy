package javaStudy;

public class ThreadLocalTest {

    public static ThreadLocal<String> threadLocalVar = new ThreadLocal<String>() {
        @Override
        public String initialValue() {
            Thread t = Thread.currentThread();
            System.out.println(t.getName() + "调用get方法时，当前线程共享变量没有设置，调用initialValue获取默认值！");
            //return "hello";
            return null;
        }
    };

    public static void main(String[] args) {
        new Thread(new SimpleThread("beijing")).start();
        new Thread(new SimpleThread("北京")).start();
    }

}

class SimpleThread implements Runnable {
    private String value;

    public SimpleThread(String value) {
        this.value = value;
    }


    public void run() {
        Thread t = Thread.currentThread();
        String value1 = ThreadLocalTest.threadLocalVar.get();
        System.out.println("threadName=" + t.getName() + ";最初value1=" + value1);
        ThreadLocalTest.threadLocalVar.set(value);
        String value2 = ThreadLocalTest.threadLocalVar.get();
        System.out.println("threadName=" + t.getName() + ";设值后value2=" + value2);
        ThreadLocalTest.threadLocalVar.remove();
        String value3 = ThreadLocalTest.threadLocalVar.get();
        System.out.println("threadName=" + t.getName() + ";删除后value3=" + value3);
    }
}
