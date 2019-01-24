package mqStudy.ack.shiwu;

import com.rabbitmq.client.*;

import java.io.IOException;


/**
 * 保证消息不丢：
 * 1）消息生产者需要开启事务机制或者 publisher confirm 机制，以确保消息可以可靠地传 输到 RabbitMQ 中。
 * 2）消息生产者需要配合使用 mandatory 参数或者备份交换器来确保消息能够从交换器 路由到队列中，进而能够保存下来而不会被丢弃。
 * 3）消息和队列都需要进行持久化处理，以确保 RabbitMQ 服务器在遇到异常情况时不会造成消息丢失。
 * 4）消费者在消费消息的同时需要将 autoAck 设置为 false，然后通过手动确认的方式去 确认己经正确消费的消息，以避免在消费端引起不必要的消息丢失。
 */
public class ShiwuReceive {

    private static String QUEUE_NAME = "ack_queue";

    public static void main(String[] args){
        try {
            ConnectionFactory factory = new ConnectionFactory();
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            Consumer consumer = new DefaultConsumer(channel){
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String newMessage = new String(body,"UTF-8");
                    System.out.println("ShiwuReceive收到"+newMessage);

                    //手动确认
                    channel.basicAck(envelope.getDeliveryTag(),false);
                }
            };
            //设置autoAck为false
            channel.basicConsume(QUEUE_NAME,false,consumer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
