package thread;


/**
 *  结论：A: synchronized static是某个类的范围，
 *  synchronized static cSync{}防止多个线程同时访问这个类中的synchronized static 方法。
 *  它可以对类的所有对象实例起作用。
 *
 *  B: synchronized 是某实例的范围，synchronized isSync(){}防止多个线程
 *  同时访问这个实例中的synchronized 方法。
 */
public class SynchronizedTest {


    public static void main(String[] args){
        Something x = new Something();
        Something y = new Something();
        // x.isSyncA()与x.isSyncB(),//都是对同一个实例的synchronized域访问，因此不能被同时访问
        //x.isSyncA();
        // x.isSyncB();

        //x.isSyncA()与y.isSyncA()   //是针对不同实例的，因此可以同时被访问
        //x.isSyncA();
        //y.isSyncA();

        //x.cSyncA()与y.cSyncB()
        /**
         * 因为是static synchronized，所以不同实例之间仍然会被限制,
         * 相当于Something.isSyncA()与   Something.isSyncB()了，因此不能被同时访问。
         */
        //x.cSyncA();
        //y.cSyncB();

        //x.isSyncA()与Something.cSyncA()
        /**
         * 答案是可以被同时访问的，答案理由是synchronzied的是实例方法与synchronzied的类方法由于锁定（lock）不同的原因。
         *    个人分析也就是synchronized 与static synchronized 相当于两帮派，
         *    各自管各自，相互之间就无约束了，可以被同时访问。目前还不是分清楚java内部设计synchronzied是怎么样实现的。
         */
        x.isSyncA();
        Something.cSyncA();
    }

}

class Something{
    public synchronized void isSyncA(){
        System.out.println("isSyncA()开始");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("isSyncA()结束");
    }
    public synchronized void isSyncB(){
        System.out.println("isSyncB()开始");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("isSyncB()结束");
    }
    public static synchronized void cSyncA(){
        System.out.println("cSyncA()开始");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("cSyncA()结束");
    }
    public static synchronized void cSyncB(){
        System.out.println("cSyncB()开始");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("cSyncB()结束");
    }
}
