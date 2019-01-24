package mqStudy.direct;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class EmitLog {
    private static final String EXCHANGE_NAME = "logs2";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "direct");
        //debug日志
        for (int i = 1; i <= 3; i++) {
            String message = "debug_message" + i;
            channel.basicPublish(EXCHANGE_NAME, "debug", null, message.getBytes());
        }
        //info日志
        for (int i = 1; i <= 3; i++) {
            String message = "info_message" + i;
            channel.basicPublish(EXCHANGE_NAME, "info", null, message.getBytes());
        }
        //error日志
        for (int i = 1; i <= 3; i++) {
            String message = "error_message" + i;
            channel.basicPublish(EXCHANGE_NAME, "error", null, message.getBytes());
        }
        channel.close();
        connection.close();
    }
}
