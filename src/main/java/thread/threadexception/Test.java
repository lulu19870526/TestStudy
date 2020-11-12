package thread.threadexception;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池中的某个线程执行过程中出现了未被捕获的异常会怎么处理
 * execute执行方式抛出异常显式在控制台了
 */
public class Test {

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
                    int j = 1/0;
                }
            });
        }
    }
}
