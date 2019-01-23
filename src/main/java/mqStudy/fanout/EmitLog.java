package mqStudy.fanout;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class EmitLog {
    private static final String EXCHANGE_NAME = "logs";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        for (int i = 1; i <=10; i++) {
            String message = "message" + i;
            channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());// arg0：不再使用""默认交换机，args1：有了交换机名，不再填对routingKey名
        }
        channel.close();
        connection.close();
    }

}

