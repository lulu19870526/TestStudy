package mqStudy.ack.shiwu;

import com.rabbitmq.client.*;

import java.io.IOException;


public class ShiwuSend {
    private static String QUEUE_NAME = "ack_queue";
    private static String EXCHANGE_NAME = "ack_exchange";

    public static void main(String[] args){
        try {
            ConnectionFactory factory = new ConnectionFactory();
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            //交换器type为fanout,且是持久化的
            channel.exchangeDeclare(EXCHANGE_NAME,"fanout",true);
            //队列持久化
            channel.queueDeclare(QUEUE_NAME,true,false,false,null);
            channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"");

            for(int i=0;i< 10;i++){
                String message = "第"+i+"条消息";
                try {
                    channel.txSelect();
                    //消息持久化
                    /**
                     *  当mandatory标志位设置为true时，如果exchange根据自身类型和消息routingKey无法找到一个合适的queue存储消息，
                     *  那么broker会调用basic.return方法将消息返还给生产者;当mandatory设置为false时，出现上述情况broker会直接将消息丢弃;
                     *  通俗的讲，mandatory标志告诉broker代理服务器至少将消息route到一个队列中，否则就将消息return给发送者;
                     */
                    channel.basicPublish(EXCHANGE_NAME,"",true, MessageProperties.PERSISTENT_TEXT_PLAIN,message.getBytes());
                    channel.txCommit();
                } catch (Exception e) {
                    e.printStackTrace();
                    channel.txRollback();
                }
            }

            //exchange根据自身类型和消息routingKey无法找到一个合适的queue存储消息，那么broker会调用basic.return方法将消息返还给生产者
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
