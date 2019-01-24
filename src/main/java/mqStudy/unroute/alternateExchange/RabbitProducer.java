package mqStudy.unroute.alternateExchange;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class RabbitProducer {
    private static final String EXCHANGE_NAME = "exchange_demo";
    private static final String BINDING_KEY = "bingkey_demo";
    private static final String QUEUE_NAME = "queue_demo";
    private static final String IP_ADDRESS = "localhost";
    private static final int PORT = 5672;

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(IP_ADDRESS);
        connectionFactory.setPort(PORT);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");

        try {
            // 创建一个连接
            Connection connection = connectionFactory.newConnection();
            // 创建信道
            Channel channel = connection.createChannel();

            Map<String, Object> arguments = new HashMap<>(16);
            arguments.put("alternate-exchange", "backup-exchange");
            channel.exchangeDeclare(EXCHANGE_NAME, "direct", true, false, arguments);
            channel.queueDeclare(QUEUE_NAME, true, false, false, null);
            channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, BINDING_KEY);

            // 声明一个 fanout 类型的交换器，建议此处使用 fanout 类型的交换器
            channel.exchangeDeclare("backup-exchange", "fanout", true, false, null);
            // 消息没有被路由的之后存入的队列
            channel.queueDeclare("unRoutingQueue", true, false, false, null);
            channel.queueBind("unRoutingQueue", "backup-exchange", "");

            // 发送一条持久化消息
            String message = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " 没有被正确的路由到消息队列，此时此消息会进入 unRoutingQueue";
            try {
                // 使用 routingKey
                channel.basicPublish(EXCHANGE_NAME, "not-exists-routing-key", true, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes(StandardCharsets.UTF_8));
                System.err.println("消息发送完成......");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
        e.printStackTrace();
        }
    }
}
