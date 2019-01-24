package mqStudy.mandatory;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * mandatory标志的作用：在消息没有被路由到合适队列情况下会将消息返还给消息发布者，
 * 同时我们测试了哪些情况下消息不会到达合适的队列，测试1演示的是创建了exchange但是没有为他绑定队列导致的消息未到达合适队列，
 * 测试3演示的是创建了exchange同时创建了queue，但是在将两者绑定的时候，使用的bindingKey和消息发布者使用的rountingKey不一致导致的
 * 消息未到达合适队列
 */
public class MandatorySend {
    private static String EXCHANGE_NAME = "mandatory_exchange";

    public static void main(String[] args){
        try {
            ConnectionFactory factory = new ConnectionFactory();
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            channel.exchangeDeclare(EXCHANGE_NAME,"direct",true,false,null);

            for(int i=0;i<10;i++){
                String meessage = "第"+i+"条消息";
                /**
                 * void basicPublish(String exchange, String routingKey, boolean mandatory, BasicProperties props, byte[] body)
                 *  exchange：交换机名称
                 *  routingKey：路由键
                 *  props：消息属性字段，比如消息头部信息等等
                 *  body：消息主体部分
                 *
                 *    当mandatory标志位设置为true时，如果exchange根据自身类型和消息routingKey无法找到一个合适的queue存储消息，
                 *    那么broker会调用basic.return方法将消息返还给生产者;当mandatory设置为false时，出现上述情况broker会直接将消息丢弃;
                 *    通俗的讲，mandatory标志告诉broker代理服务器至少将消息route到一个队列中，否则就将消息return给发送者;
                 */
                channel.basicPublish(EXCHANGE_NAME,"",true, MessageProperties.PERSISTENT_TEXT_PLAIN,meessage.getBytes());
            }
            channel.addReturnListener(new ReturnListener() {
                @Override
                public void handleReturn(int i, String s, String s1, String s2, AMQP.BasicProperties basicProperties, byte[] bytes) throws IOException {
                    String newMessage = new String(bytes,"UTF-8");
                    System.out.println("basic.return返回的数据为"+newMessage);
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
