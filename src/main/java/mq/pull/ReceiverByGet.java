package mq.pull;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.GetResponse;

import java.util.concurrent.TimeUnit;

/**
 * https://www.cnblogs.com/gordonkong/p/6939046.html
 * mq拉模式
 */
public class ReceiverByGet {


    private final static String QUEUE_NAME = "hello";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        while (true) {
            /**
             *  basicGet 方法，主动去第一个参数指定的队列（hello队列）尝试获取一个消息，
             *  这是一个非阻塞方法，当从队列中获取消息失败时，会返回 null，
             *  成功则返回 GetResponse 实例。
             *  第二个参数 autoAck 指定消息确认模式，作用同前文 basicConsume 方法同名参数。
             */
            GetResponse resp = channel.basicGet(QUEUE_NAME, true);
            if (resp == null) {
                System.out.println("Get Nothing!");
                TimeUnit.MILLISECONDS.sleep(1000);
            } else {
                String message = new String(resp.getBody(), "UTF-8");
                System.out.printf(" [    %2$s<===](%1$s) %3$s\n", "Receiver", QUEUE_NAME, message);
                TimeUnit.MILLISECONDS.sleep(500);
            }
        }
    }
}
