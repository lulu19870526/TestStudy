package javaStudy.locksemaphore;

import java.util.concurrent.Semaphore;

/**
 * 线程在调用release()之前并不要求先调用acquire()
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(1);//总共有1个许可
        System.out.println("可用的许可数目为："+semaphore.availablePermits());
        semaphore.release();
        System.out.println("可用的许可数目为："+semaphore.availablePermits());
    }

}
