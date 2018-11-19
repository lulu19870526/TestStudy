package thread.queue;

import java.util.concurrent.LinkedBlockingQueue;

public class QueueProducerConsumer {
    // 建立一个阻塞队列,阻塞的线程安全的队列，底层采用链表实现
    private static LinkedBlockingQueue<Object> queue = new LinkedBlockingQueue<Object>(10);

    public static void main(String[] args){
        new Producer().start();
        new Consumer().start();

    }

    static class Producer extends Thread {
        public void run() {
            while (true) {
                try {
                    Object o = new Object();
                    /**
                     * 若向队尾添加元素的时候发现队列已经满了会发生阻塞一直等待空间，
                     * 以加入元素。
                     */
                    queue.put(o); //队列满时会自动阻塞
                    System.out.println("Producer: " + o);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer extends Thread {
        public void run() {
            while (true) {
                try {
                    /**
                     * 从队列中取出并移除头元素,若队列为空，发生阻塞，等待有元素
                     */
                    Object o = queue.take();
                    System.out.println("Consumer: " + o);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }



}
