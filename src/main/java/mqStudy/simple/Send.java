package mqStudy.simple;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;


/**
 *
 * 简单模式：一个生产者，一个消费者
 * 生产者产生消息，消费者消费消息。
 * rabbitmq的队列基本上是无界的，生产者不停的生产消息放入队列，消费者阻塞式的获取消息，获得后去处理
 */
public class Send {
    private final static String QUEUE_NAME = "simple";

    public static void main(String[] args) throws IOException, TimeoutException {
        // 初始化
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");//此处可以设置多个属性，包括IP地址以及认证账号等信息
        Connection connection = factory.newConnection();// 获取连接  Connection代表了一个socket链接，具有协议协商和认证的功能；
        Channel channel = connection.createChannel();// 获取通道
        //声明一个队列（如果不存在则创建，如果存在且属性设置一样则不变，如果属性设置不同，则报错
        //队列名称+是否需要持久化（服务重启后可恢复）+是否是排他性的（只属于本connection）+是否自动删除（不再使用时服务器自动删除）+其他属性设置
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        //定义消息
        String message = "this is a message";
        // 发送消息
        // exchange名称+路由关键字(exchange名字为""时代表队列名称)+消息的其他设置信息+消息内容字节数组
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        //关闭链接，如果不关闭，connection会以配置的时间间隔心跳保持链接的可用性（如果空闲时间过长，有的系统会强制关闭链接）
        channel.close();
        connection.close();
    }
}

