package javaStudy.locksemaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class WorkThread2 extends Thread{
    private Semaphore semaphore1,semaphore2;
    public WorkThread2(Semaphore semaphore1,Semaphore semaphore2){
        this.semaphore1=semaphore1;
        this.semaphore2=semaphore2;
    }
    public void releaseSemaphore2(){
        System.out.println(Thread.currentThread().getId()+" 释放Semaphore2");
        semaphore2.release();
    }
    public void run() {
        try {
            semaphore1.acquire(); //先获取Semaphore1
            System.out.println(Thread.currentThread().getId()+" 获得Semaphore1");
            TimeUnit.SECONDS.sleep(5); //等待5秒让WorkThread1先获得Semaphore2
            semaphore2.acquire();//获取Semaphore2
            System.out.println(Thread.currentThread().getId()+" 获得Semaphore2");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class WorkThread1 extends Thread{
    private Semaphore semaphore1,semaphore2;
    public WorkThread1(Semaphore semaphore1,Semaphore semaphore2){
        this.semaphore1=semaphore1;
        this.semaphore2=semaphore2;
    }
    public void run() {
        try {
            semaphore2.acquire();//先获取Semaphore2
            System.out.println(Thread.currentThread().getId()+" 获得Semaphore2");
            TimeUnit.SECONDS.sleep(5);//等待5秒，让WorkThread1先获得Semaphore1
            semaphore1.acquire();//获取Semaphore1
            System.out.println(Thread.currentThread().getId()+" 获得Semaphore1");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
