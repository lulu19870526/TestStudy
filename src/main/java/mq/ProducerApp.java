package mq;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;


/**
 * https://blog.csdn.net/u011126891/article/details/54288263
 * 使用默认Default Exchange的消息生产/消费
 * 我们定义一个生产者程序，一个消费者程序。
 */
public class ProducerApp {

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = null;
        Channel channel = null;
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            factory.setPort(5672);
            factory.setUsername("rabbitmq_producer");
            factory.setPassword("123456");
            factory.setVirtualHost("test_vhosts");

            //创建与RabbitMQ服务器的TCP连接
            connection = factory.newConnection();
            channel = connection.createChannel();
            //Channel建立后，调用Channel.queueDeclare方法创建消息队列firstQueue。
            channel.queueDeclare("firstQueue", true, false, false, null);
            String message = "First Message";
            //生产者发送消息使用Channel.basicPublish方法。
            channel.basicPublish("", "firstQueue", null, message.getBytes());
            System.out.println("Send Message is:'" + message + "'");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (channel != null) {
                channel.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
