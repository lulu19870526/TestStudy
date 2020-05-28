package javaStudy.callable.futuretask;

import javaStudy.callable.MyCallable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Callable两种执行方式
 * 1、借助FutureTask执行
 *   FutureTask类同时实现了两个接口，Future和Runnable接口，所以它既可以作为Runnable被线程执行，又可以作为Future得到Callable的返回值。
 */
public class Test {

    public static void main(String[] args){
        try {
            //创建Callable对象
            MyCallable myCallable = new MyCallable();
            //开始线程
            FutureTask<Integer> futureTask = new FutureTask<Integer>(myCallable);
            new Thread(futureTask).start();
            //通过futuretask可以得到MyCallable的call()的运行结果：
            Integer result =  futureTask.get();
            System.out.println("result:" + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
