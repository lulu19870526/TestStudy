package thread.interrupt;

public class MyThread  implements Runnable{

    public void run(){
        System.out.println(Thread.currentThread().getName()+"开始执行");


        /**
         * myThread.interrupt();//中断的是调用interrupt()方法的线程
         * 阻塞于wait/join/sleep的线程，中断状态会被清除掉，同时收到著名的InterruptedException；
         */
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            /**
             *  myThread.isInterrupted();//判断本线程myThread是否中断
             * 如果已经中断，则返回true，否则false。中断状态不受该方法的影响
             */
            System.out.println(Thread.currentThread().getName()+"被interrupt,中断状态为"+
                    Thread.currentThread().isInterrupted());
        }
        System.out.println(Thread.currentThread().getName()+"结束");
    }
}

class Test{
    public static void main(String[] args){
        System.out.println(Thread.currentThread().getName()+"开始");
        Thread t = new Thread(new MyThread());
        t.start();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.interrupt();

        System.out.println("将要中断本线程"+Thread.currentThread().getName());
        Thread.currentThread().interrupt();//中断的是调用interrupt()方法的线程
        /**
         * Thread.interrupted();//判断该语句所在线程是否中断
         * 如果已经中断，则返回true，否则false，并清除中断状态。
         * 换言之，如果该方法被连续调用两次，第二次必将返回false，除非在第一次与第二次的瞬间线程再次被中断。
         * 如果中断调用时线程已经不处于活动状态，则返回false。
         */
        System.out.println("第一次返回值："+Thread.interrupted());
        System.out.println("第二次返回值："+Thread.interrupted());
        System.out.println(Thread.currentThread().getName()+"结束");
    }

}
