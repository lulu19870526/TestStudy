package mqStudy.simple;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class Recv {

    private final static String QUEUE_NAME = "simple";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection conection = factory.newConnection();
        Channel channel = conection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        //创建消费者，在回调函数中处理结果
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body)
                    throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println("从队列"+QUEUE_NAME+"接受到：" + message);
            }
        };
        /**
         * String basicConsume(String queue, boolean autoAck, Consumer callback) throws IOException;
         * queue 队列名
         * autoAck 是否自动确认消息,true自动确认,false 不自动要手动调用,建立设置为false
         * callback 消费者 DefaultConsumer建立使用，重写其中的方法
         */
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}