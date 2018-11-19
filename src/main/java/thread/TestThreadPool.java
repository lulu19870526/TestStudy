package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TestThreadPool {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 20, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(2),
                new ThreadFactory() {
                    private AtomicInteger threadIndex = new AtomicInteger(0);

                    public Thread newThread(Runnable r) {
                        return new Thread(r, "T" + this.threadIndex.incrementAndGet());
                    }
                },
                new ThreadPoolExecutor.DiscardOldestPolicy());

        for(int i=0;i<9;i++){
            MyTask myTask = new MyTask(i);
            System.out.println("创建任务并提交到线程池中：任务" + i);
            executor.execute(myTask);
            System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
                    executor.getQueue().size()+"，已执行玩别的任务数目："+executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }

}

class MyTask implements Runnable {
    private int taskNum;

    public MyTask(int num) {
        this.taskNum = num;
    }

    public void run() {
        System.out.println("正在执行task " + taskNum + ";Thread.currentThread().getName()=" + Thread.currentThread().getName());
        try {
            Thread.currentThread().sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task " + taskNum + "执行完毕" + ";Thread.currentThread().getName()=" + Thread.currentThread().getName());
    }
}
