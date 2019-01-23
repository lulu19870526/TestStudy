package mqStudy.work;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class Work1 {
    private static final String QUEUE_NAME = "task_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        final Channel channel = connection.createChannel();
        //标记queue持久化
        //boolean durable = true;
        //channel.queueDeclareNoWait(QUEUE_NAME, durable, false, false, null);
        channel.basicQos(1);// 负载均衡
        final Consumer consumer = new DefaultConsumer(channel) {

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body)
                    throws IOException {
                String message = new String(body, "UTF-8");
                try {
                    doWork(message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("envelope="+ JSON.toJSONString(envelope));
                    channel.basicAck(envelope.getDeliveryTag(), false);
                }
            }
        };
        boolean autoAck = false;// 自动回复确认,默认为true,生产者已发送就会将其标记为：已删除
        channel.basicConsume(QUEUE_NAME, autoAck, consumer);
    }

    protected static void doWork(String message) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("work1收到消息：" + message);
    }
}
