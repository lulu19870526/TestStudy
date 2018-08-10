import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zengqx on 2018/4/12.
 */
public class TestBianliangValue {
    static int COUNT_BITS = Integer.SIZE - 3;
    static int CAPACITY   = (1 << COUNT_BITS) - 1;

    public static void main(String args[]){


        System.out.println("COUNT_BITS="+COUNT_BITS);
        System.out.println("CAPACITY="+CAPACITY);

        // runState is stored in the high-order bits
        int RUNNING    = -1 << COUNT_BITS;
        int SHUTDOWN   =  0 << COUNT_BITS;
        int STOP       =  1 << COUNT_BITS;
        int TIDYING    =  2 << COUNT_BITS;
        int TERMINATED =  3 << COUNT_BITS;
        System.out.println("RUNNING="+RUNNING+";二进制为"+Integer.toBinaryString(RUNNING));
        System.out.println("SHUTDOWN="+SHUTDOWN+";二进制为"+Integer.toBinaryString(SHUTDOWN));
        System.out.println("STOP="+STOP+";二进制为"+Integer.toBinaryString(STOP));
        System.out.println("TIDYING="+TIDYING+";二进制为"+Integer.toBinaryString(TIDYING));
        System.out.println("TERMINATED="+TERMINATED+";二进制为"+Integer.toBinaryString(TERMINATED));

        AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
        System.out.println("ctl="+ctl);
        int c = ctl.get();
        System.out.println("c="+c);

        int workerCount = workerCountOf(c);
        System.out.println("workerCount="+workerCount);

        int runState = runStateOf(c);
        System.out.println("runState="+runState+";二进制为runState="+Integer.toBinaryString(runState));

        ctl.getAndIncrement();
        System.out.println("ctl=" + ctl);
        int c1 = ctl.get();
        System.out.println("c1=" + c1+";二进制为c1="+Integer.toBinaryString(c1));

        int runState1 = runStateOf(c1);
        System.out.println("runState1="+runState1+";二进制为runState1="+Integer.toBinaryString(runState1));

    }

    public static int ctlOf(int rs, int wc) {
        System.out.println("二进制为rs="+Integer.toBinaryString(rs));
        System.out.println("二进制为wc="+Integer.toBinaryString(wc));
        return rs | wc;
    }

    public static int workerCountOf(int c)  { return c & CAPACITY; }

    public static int runStateOf(int c)     { return c & ~CAPACITY; }
}
