package javaStudy.callable;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {


    @Override
    public Integer call() throws Exception {
        //TODO 线程执行方法
        int i;
        for(i = 0;i < 10;i++){
            System.out.println("i="+i);
        }
        return i;
    }
}