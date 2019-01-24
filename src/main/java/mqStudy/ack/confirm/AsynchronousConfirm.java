package mqStudy.ack.confirm;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Channel对象提供的ConfirmListener()回调方法只包含deliveryTag（当前Chanel发出的消息序号），
 * 我们需要自己为每一个Channel维护一个unconfirm的消息序号集合，每publish一条数据，集合中元素加1，
 * 每回调一次handleAck方法，unconfirm集合删掉相应的一条（multiple=false）或多条（multiple=true）记录。
 * 从程序运行效率上看，这个unconfirm集合最好采用有序集合SortedSet存储结构。
 */
public class AsynchronousConfirm {

    private static String QUEUE_NAME = "ack_queue";
    private static String EXCHANGE_NAME = "ack_exchange";

    public static void main(String[] args) {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            //交换器type为fanout,且是持久化的
            channel.exchangeDeclare(EXCHANGE_NAME, "fanout", true);
            //队列持久化
            channel.queueDeclare(QUEUE_NAME, true, false, false, null);
            channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "");


            /**
             * SortedSet继承自Set，他根据对象的比较顺序（可以是自然顺序，也可以是自定义的顺序），而不是插入顺序进行排序；
             * TreeSet是SortedSet的唯一实现类，红黑树实现，树形结构，它的本质可以理解为是有序，无重复的元素的集合。
             * public SortedSet<E> headset(E toElement):返回从开始到指定元素的集合
             */
            SortedSet<Long> confirmSet = Collections.synchronizedSortedSet(new TreeSet<Long>());
            channel.confirmSelect();
            channel.addConfirmListener(new ConfirmListener() {
                public void handleAck(long deliveryTag, boolean multiple) throws IOException {
                    System.out.println("ack, SeqNo: " + deliveryTag + ", multiple: " + multiple);
                    if (multiple) {
                        confirmSet.headSet(deliveryTag + 1).clear();
                    } else {
                        confirmSet.remove(deliveryTag);
                    }
                }
                public void handleNack(long deliveryTag, boolean multiple) throws IOException {
                    System.out.println("Nack, SeqNo: " + deliveryTag + ", multiple: " + multiple);
                    if (multiple) {
                        confirmSet.headSet(deliveryTag + 1).clear();
                    } else {
                        confirmSet.remove(deliveryTag);
                    }
                }
            });

            for (int i = 0; i < 10; i++) {
                String message = "第" + i + "条消息";
                long nextSeqNo = channel.getNextPublishSeqNo();
                System.out.println("nextSeqNo="+nextSeqNo+";i为"+i);
                channel.basicPublish(EXCHANGE_NAME , "", MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
                confirmSet.add(nextSeqNo);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}
