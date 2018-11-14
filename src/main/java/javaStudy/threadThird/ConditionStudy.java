package javaStudy.threadThird;

import java.util.concurrent.locks.*;

/**
 * Created by zengqx on 2018/11/13.
 */
public class ConditionStudy {

    private static Lock lock = new ReentrantLock();
    /*
    public ReentrantLock() {
        sync = new NonfairSync();
    }

    static final class NonfairSync extends Sync {
        private static final long serialVersionUID = 7316153563782823691L;
    }
    */

    private static Condition condition = lock.newCondition();

    /**
    public Condition newCondition() {
        return sync.newCondition();
    }
    abstract static class Sync extends AbstractQueuedSynchronizer {
        private static final long serialVersionUID = -5179523762034025860L;

        final ConditionObject newCondition() {
            return new ConditionObject();
        }
    }
     */

    /*
    public class ConditionObject implements Condition, java.io.Serializable {
        private static final long serialVersionUID = 1173984872572414699L;

        //condition队列第一个node节点
        private transient Node firstWaiter;

        //condition队列最后一个node节点
        private transient Node lastWaiter;


        public ConditionObject() {
        }


        public final void await() throws InterruptedException {
            if (Thread.interrupted())//判断当前线程是否被中断，如果中断则直接抛出异常
                throw new InterruptedException();
            Node node = addConditionWaiter();//把当前线程为一个Node，然后加入到condition队列中去（队尾)
            int savedState = fullyRelease(node);
            int interruptMode = 0;
            while (!isOnSyncQueue(node)) {
                LockSupportTest.park(this);
                if ((interruptMode = checkInterruptWhileWaiting(node)) != 0)
                    break;
            }
            if (acquireQueued(node, savedState) && interruptMode != THROW_IE)
                interruptMode = REINTERRUPT;
            if (node.nextWaiter != null) // clean up if cancelled
                unlinkCancelledWaiters();
            if (interruptMode != 0)
                reportInterruptAfterWait(interruptMode);
        }


        //把当前线程为一个Node，然后加入到condition队列中去（队尾)
        private Node addConditionWaiter() {
            Node t = lastWaiter;
            //condition队列中尾Node节点的waitStatus不为Node.CONDITION即-2，则表示该节点不处于等待状态，需要清除condition队列中所有waitStatus不为Node.CONDITION即-2的节点
            if (t != null && t.waitStatus != Node.CONDITION) {
                unlinkCancelledWaiters();
                t = lastWaiter;//清除操作后要重新取condition队列中尾Node节点
            }
            Node node = new Node(Thread.currentThread(), Node.CONDITION);
            if (t == null)
                firstWaiter = node;
            else
                t.nextWaiter = node;
            lastWaiter = node;
            return node;
        }

        //将condition队列中waitStatus不为Node.CONDITION即-2的节点删除
        private void unlinkCancelledWaiters() {
            Node t = firstWaiter;
            Node trail = null;//依次指向waitStatus为Node.CONDITION即-2的node节点
            while (t != null) {
                Node next = t.nextWaiter;
                if (t.waitStatus != Node.CONDITION) {
                    t.nextWaiter = null;
                    if (trail == null)
                        firstWaiter = next;
                    else
                        trail.nextWaiter = next;
                    if (next == null)
                        lastWaiter = trail;
                }
                else
                    trail = t;
                t = next;
            }
        }

        final int fullyRelease(Node node) {
            boolean failed = true;
            try {
                int savedState = getState();//获取重入锁的次数
                if (release(savedState)) {
                    failed = false;
                    return savedState;
                } else {
                    throw new IllegalMonitorStateException();
                }
            } finally {
                if (failed)
                    node.waitStatus = Node.CANCELLED;
            }
        }

        //获取重入锁的次数，如果为0则代表锁没有被占用
        protected final int getState() {
            return state;
        }

        public final boolean release(int arg) {
            if (tryRelease(arg)) {
                Node h = head;
                if (h != null && h.waitStatus != 0)
                    unparkSuccessor(h);
                return true;
            }
            return false;
        }

        protected final boolean tryRelease(int releases) {
            int c = getState() - releases;
            if (Thread.currentThread() != getExclusiveOwnerThread())
                throw new IllegalMonitorStateException();
            boolean free = false;
            if (c == 0) {
                free = true;
                setExclusiveOwnerThread(null);
            }
            setState(c);
            return free;
        }

        protected final Thread getExclusiveOwnerThread() {
            return exclusiveOwnerThread;
        }


    }
    */
}
