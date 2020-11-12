package thread.threadexception.submit;

import java.util.concurrent.*;

public class TestCatchException {
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
           Future future = threadPoolExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"执行任务");
                    int j = 1/0;
                }
            });
            /**
             * submit提交时异常被存储在线程结果信息中，当调用get方法是判断线程运行结果状态，
             * 有异常就抛出存储的异常信息，因此submit运行异常我们只能用get方法来拿到
             */
            try {
                future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
