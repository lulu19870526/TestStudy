package thread.threadexception;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test2 {
    public static void main(String[] args){
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(1, 1,
                        60, TimeUnit.SECONDS,
                        new ArrayBlockingQueue<>(200), Executors.defaultThreadFactory()){

                    /**
                     * 仅仅获取异常信息
                     * @param r
                     * @param t
                     */
                    @Override
                    protected void afterExecute(Runnable r, Throwable t) {
                        super.afterExecute(r, t);
                        System.out.println("afterExecute里面获取到异常信息"+t.getMessage());
                    }

                };

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
