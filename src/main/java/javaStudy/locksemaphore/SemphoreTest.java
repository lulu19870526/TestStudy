package javaStudy.locksemaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemphoreTest {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore1=new Semaphore(1);
        Semaphore semaphore2=new Semaphore(1);
        new WorkThread1(semaphore1, semaphore2).start();
        new WorkThread2(semaphore1, semaphore2).start();

        /**
         * 此时已经陷入了死锁，WorkThread1持有semaphore1的许可，请求semaphore2的许可
         * WorkThread2持有semaphore2的许可，请求semaphore1的许可
         */

        /**
         * 解决死锁
         * 通过一个非owner的线程来实现死锁恢复，但如果你使用的是Lock则做不到，
         * 可以把代码中的两个信号量换成两个锁对象试试。很明显，前面也验证过了，
         * 要使用Lock.unlock()来释放锁，首先你得拥有这个锁对象，
         * 因此非owner线程（事先没有拥有锁）是无法去释放别的线程的锁对象
         */
        TimeUnit.SECONDS.sleep(10);
        semaphore1.release();
        semaphore2.release();

    }

}
