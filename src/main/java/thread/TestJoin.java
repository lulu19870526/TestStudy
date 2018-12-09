package thread;

import static java.lang.Thread.sleep;

public class TestJoin implements Runnable {


    public static void main(String[] sure) throws InterruptedException {
        Thread t = new Thread(new TestJoin());
        long start = System.currentTimeMillis();
        t.start();
        /**
         * 如果millis大于0，则wait(millis),实际上释放锁，等被唤醒,唤醒后还要检查是否到了时间，
         * 如果还没到，则继续wait(剩余时间);只有到了等待的时间才可继续往下执行；如果还没到时间但是线程结束了也会结束的
         */
        t.join(6000);
        /**
         * 第一次执行后，执行wait(0),然后等待线程执行完即死亡就退出（中间不循环）
         */
        //t.join();
        System.out.println(System.currentTimeMillis()-start);//打印出时间间隔
        System.out.println("Main finished");//打印主线程结束
    }

    @Override
    public void run() {
        // synchronized (currentThread()) {
        for (int i = 1; i <= 5; i++) {
            try {
                sleep(1000);//睡眠5秒，循环是为了方便输出信息
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("睡眠" + i);
        }
        System.out.println("TestJoin finished");//t线程结束
    }
    //}
}
