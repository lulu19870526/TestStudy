package javaStudy;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zengqx on 2018/11/9.
 */
public class TestProductorAndConsumerForLock {

    public static void main(String[] args) {
        Clerk clerk=new Clerk();
        Productor pro=new Productor(clerk);
        Consumer1 cus=new Consumer1(clerk);

        //new Thread(pro,"生产者A").start();
        new Thread(cus,"消费者B").start();

        //new Thread(pro,"生产者C").start();
        new Thread(cus,"消费者D").start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(pro,"生产者A").start();
    }
}

//店员
class Clerk{

    private int product=0;

    private Lock lock=new ReentrantLock();
    private Condition condition=lock.newCondition();

    //进货
    public void get(){
        lock.lock();

        try {
            while (product >= 1) { //为了避免虚假唤醒 问题，应该总是使用在循环中
                System.out.println(Thread.currentThread().getName() +"产品已满");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                }
            }
            System.out.println(Thread.currentThread().getName() + " : " + (++product));
            condition.signalAll();

        } finally {
            lock.unlock();
        }
    }

    public  void sale(){
        lock.lock();
        try {
            while (product <= 0) { //为了避免虚假唤醒 问题，应该总是使用在循环中
                System.err.println(Thread.currentThread().getName() +"缺货");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                }
            }

            System.out.println(Thread.currentThread().getName() + " : " + (--product));
            condition.signalAll();

        } finally {
            lock.unlock();
        }
    }
}

//生产者
class Productor implements Runnable{

    private Clerk clerk;

    public Productor(Clerk clerk){
        this.clerk=clerk;
    }

    public void run() {
        clerk.get();
    }
}

//消费者
class Consumer1 implements Runnable{

    private Clerk clerk;

    public Consumer1(Clerk clerk){
        this.clerk=clerk;
    }

    public void run() {
        clerk.sale();
    }
}
