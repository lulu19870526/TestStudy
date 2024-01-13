package delayQueue;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author: zengqx
 * @Date: 2024/1/13 10:27
 */
public class DelayQueueDemo {
    /**
     * DelayQueue是一个支持时延获取元素的无界阻塞队列。队列使用PriorityQueue来实现。
     * 队列中的元素必须实现Delayed接口，在创建元素时可以指定多久才能从队列中获取当前元素。
     * 只有在延迟期满时才能从队列中提取元素。
     * DelayQueue可以运用在以下两个应用场景：
     * 缓存系统的设计：使用DelayQueue保存缓存元素的有效期，使用一个线程循环查询DelayQueue，一旦能从DelayQueue中
     * 获取元素时，就表示有缓存到期了。
     * 定时任务调度：使用DelayQueue保存当天要执行的任务和执行时间，一旦从DelayQueue中获取到任务就开始执行，
     * 比如Tiner就是使用DelayQueue实现的。
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Message item1 = new Message("消息1", 5, TimeUnit.SECONDS);
        Message item2 = new Message("消息2", 10, TimeUnit.SECONDS);
        Message item3 = new Message("消息3", 15, TimeUnit.SECONDS);

        DelayQueue<Message> queue = new DelayQueue<Message>();
        queue.add(item1);
        queue.add(item2);
        queue.add(item3);

        int queueLengh = queue.size();
        System.out.println(printDate() + "开始!");
        for (int i = 0; i < queueLengh; i++) {
            Message take = queue.take();
            System.out.format(printDate() + " 消息出队，属性name=%s%n", take.name);
        }

        System.out.println(printDate() + "结束!");
    }

    static String printDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
}
