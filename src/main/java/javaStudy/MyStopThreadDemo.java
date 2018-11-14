package javaStudy;

/**
 *
 * Created by zengqx on 2018/11/8.
 */

class StopThread implements Runnable {
    private boolean flag = true;

    public synchronized void run() {
        System.out.println(Thread.currentThread().getName() + "....run方法开始");
        while (flag) {
            System.out.println(Thread.currentThread().getName() + "....begin");
            try {
                System.out.println(Thread.currentThread().getName() + "....wait前");
                /**
                 * 让当前线程处于“等待(阻塞)状态”，
                 * 同时，wait()也会让当前线程释放它所持有的锁，“直到其他线程调用此对象的 notify() 方法或 notifyAll() 方法”，当前线程被唤醒(进入“就绪状态”)。
                 */
                wait();
                System.out.println(Thread.currentThread().getName() + "....wait后");
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "....Exception");
                flag = false;
            }
            System.out.println(Thread.currentThread().getName() + "....run");
        }
    }

    public void changeFlag() {
        flag = false;
    }
}

class MyStopThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        StopThread st = new StopThread();

        Thread t1 = new Thread(st);
        t1.setName("线程1");
        Thread t2 = new Thread(st);
        t2.setName("线程2");

        t1.start();
        t2.start();
        Thread.sleep(100);
        int num = 0;

        while (true) {
            if (num++ == 10) {
                System.out.println(t1.getName()+" interrupt前");
                /**
                 *  wait()、join()和sleep()都可以通过interrupt()方法 打断线程的阻塞状态 ，从而使线程立刻抛出InterruptedException。
                 */
                t1.interrupt();
                System.out.println(t1.getName()+" interrupt后");
                System.out.println(t2.getName()+" interrupt前");
                t2.interrupt();
                System.out.println(t2.getName()+" interrupt后");
                break;
            }
            System.out.println(Thread.currentThread().getName() + "......."
                    + num);
        }
        System.out.println("over");
    }
}

