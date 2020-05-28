package javaStudy.callable.threadpool;

import javaStudy.callable.MyCallable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


/**
 * 借助线程池来运行Callable
 */
public class Test1 {

    public static void main(String[] args){
        try {
            //创建一个线程池
            ExecutorService executor = Executors.newCachedThreadPool();
            //创建Callable对象
            MyCallable myCallable = new MyCallable();
            //提交任务
            Future<Integer> future = executor.submit(myCallable);
            //通过futuretask可以得到MyCallable的call()的运行结果：
            Integer result =  future.get();
            System.out.println("result:" + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
