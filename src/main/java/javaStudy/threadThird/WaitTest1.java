package javaStudy.threadThird;

/**
 * Created by zengqx on 2018/11/13.
 */
public class WaitTest1 {
    public static void main(String[] args) {

    ThreadA ta = new ThreadA("ta");

    synchronized(ta) { // 通过synchronized(ta)获取“对象ta的同步锁”
        try {
            System.out.println(Thread.currentThread().getName()+" start ta");
            ta.start();

            System.out.println(Thread.currentThread().getName()+" block");
            /**
             *  让当前线程处于“等待(阻塞)状态”，同时，wait()也会让当前线程释放它所持有的锁，
             *  “直到其他线程调用此对象的 notify() 方法或 notifyAll() 方法”，当前线程被唤醒(进入“就绪状态”)。
             */
            ta.wait();    // 等待

            System.out.println(Thread.currentThread().getName()+" continue");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

    static class ThreadA extends Thread{

        public ThreadA(String name) {
            super(name);
        }

        public void run() {
            synchronized (this) { // 通过synchronized(this)获取“当前对象的同步锁”
                System.out.println(Thread.currentThread().getName()+" wakup others");
                notify();    // 唤醒“当前对象上的等待线程”
            }
        }
    }
}