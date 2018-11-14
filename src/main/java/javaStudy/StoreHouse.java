package javaStudy;

/**
 * Created by zengqx on 2018/11/5.
 */
public class StoreHouse {

    private int maxSize = 10;//最大容量
    private int size = 0;//实际容量

    //每次只生产一个
    public synchronized void produce(){
       while(size >= maxSize){
           try {
               System.out.println("线程名为:"+Thread.currentThread().getName()+",容量已满,请稍候再生产");
               wait();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
        System.out.print("线程名为:"+Thread.currentThread().getName()+",生产前size="+size);
        size ++;
        System.out.println(";生产后size=" + size);
        notifyAll();
    }

    //每次只消费一个
    public synchronized void consume(){
        while(size <= 0){
            try {
                System.out.println("线程名为:"+Thread.currentThread().getName()+",缺货,请稍候再取");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.print("线程名为:"+Thread.currentThread().getName()+",消费前size="+size);
        size --;
        System.out.println(";消费后size=" + size);
        notifyAll();
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
        new Thread(new Producer(storeHouse)).start();
    }
}
