package javaStudy.threadThird;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zengqx on 2018/11/14.
 */
public class StoreHouse {
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    private int maxSize = 10;//最大容量
    private int size = 0;//实际容量

    //每次只生产一个
    public void produce(){
        lock.lock();
        while(size >= maxSize){
            try {
                System.out.println("线程名为:"+Thread.currentThread().getName()+",容量已满,请稍候再生产");
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print("线程名为:"+Thread.currentThread().getName()+",生产前size="+size);
        size ++;
        System.out.println(";生产后size=" + size);
        condition.signalAll();
        lock.unlock();
    }

    //每次只消费一个
    public void consume(){
        lock.lock();
        while(size <= 0){
            try {
                System.out.println("线程名为:"+Thread.currentThread().getName()+",缺货,请稍候再取");
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.print("线程名为:"+Thread.currentThread().getName()+",消费前size="+size);
        size --;
        System.out.println(";消费后size=" + size);
        condition.signalAll();
        lock.unlock();
    }
}

class Producer implements Runnable {

    private StoreHouse storeHouse;
    public Producer(StoreHouse storeHouse){
        this.storeHouse = storeHouse;
    }

    public void run(){
        storeHouse.produce();
    }
}

class Consumer implements Runnable{
    private StoreHouse storeHouse;
    public Consumer(StoreHouse storeHouse){
        this.storeHouse = storeHouse;
    }

    public void run(){
        storeHouse.consume();
    }
}

class ProduceAndConsume{

    public static void main(String[] args){
        StoreHouse storeHouse = new StoreHouse();
        new Thread(new Consumer(storeHouse)).start();
        new Thread(new Consumer(storeHouse)).start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(new Producer(storeHouse)).start();
    }
}
