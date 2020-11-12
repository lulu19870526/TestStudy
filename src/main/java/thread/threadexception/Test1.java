package thread.threadexception;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test1 {
    public static void main(String[] args){
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(1, 1,
                        60, TimeUnit.SECONDS,
                        new ArrayBlockingQueue<>(200), Executors.defaultThreadFactory());

        for(int i = 0;i < 5;i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    Thread t = Thread.currentThread();
                    /**
                     * 结果并不是我们想象的那样，线程池中原有的线程没有复用！
                     * 所以通过UncaughtExceptionHandler想将异常吞掉使线程复用这招貌似行不通。
                     * 它只是做了一层异常的保底处理。
                     */
                    t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                        @Override
                        public void uncaughtException(Thread t, Throwable e) {
                            System.out.println(Thread.currentThread().getName()+"获取异常信息");
                        }
                    });
                    int j = 1/0;
                }
            });
        }
    }
}
