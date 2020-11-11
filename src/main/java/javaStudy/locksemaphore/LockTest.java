package javaStudy.locksemaphore;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 使用Lock.unlock()之前，该线程必须事先持有这个锁（通过Lock.lock()获取）
 * 否则会抛出异常，因为该线程事先并没有获取lock对象的锁：
 */
public class LockTest {

    public static void main(String[] args) {
        Lock lock=new ReentrantLock();
        lock.unlock();
    }

}
