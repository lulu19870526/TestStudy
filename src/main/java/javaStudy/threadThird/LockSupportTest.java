package javaStudy.threadThird;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by zengqx on 2018/11/14.
 */
public class LockSupportTest {
    public static void main(String args[])
    {
        Thread t = new Thread(new Runnable()
        {
            private int count = 0;

            public void run()
            {
                long start = System.currentTimeMillis();
                long end = 0;

                while ((end - start) <= 1000)
                {
                    count++;
                    end = System.currentTimeMillis();
                }

                System.out.println("after 1 second.count=" + count);

                //等待获取许可
                /**
                 * 线程如果因为调用park而阻塞的话，能够响应中断请求(中断状态被设置成true)，但是不会抛出InterruptedException
                 */
                System.out.println(Thread.currentThread().getName()+"park前");
                LockSupport.park();
                System.out.println(Thread.currentThread().getName()+"park后");
                System.out.println("thread over." + Thread.currentThread().isInterrupted());

            }
        });

        t.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 中断线程
        System.out.println(t.getName()+"被中断前");
        t.interrupt();
        System.out.println(t.getName() + "被中断后");

        System.out.println("main over");
    }
}
