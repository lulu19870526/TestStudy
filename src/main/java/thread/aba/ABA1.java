package thread.aba;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ABA1 {

    private static AtomicInteger atomicInt = new AtomicInteger(100);

    public static void main(String[] args) {
        Thread intT1 = new Thread(new Runnable() {

            public void run() {
                atomicInt.compareAndSet(100, 101);
                System.out.println("thread intT1:" + atomicInt.get());
                atomicInt.compareAndSet(101, 100);
                System.out.println("thread intT1:" + atomicInt.get());
            }
        });

        Thread intT2 = new Thread(new Runnable() {

            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                /**
                 * 线程intT2获取到的变量值A，尽管和当前的实际值相同，但内存地址V中的变量已经经历了A->B->A的改变。
                 */
                boolean c3 = atomicInt.compareAndSet(100, 101);
                System.out.println("thread intT2:" + atomicInt.get() + ",c3 is:" + c3);        //true
            }
        });

        intT1.start();
        intT2.start();
    }
}
