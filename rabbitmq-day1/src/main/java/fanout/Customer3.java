package fanout;

import com.rabbitmq.client.*;
import util.RabbitMqUtils;

import java.io.IOException;

/**
 * @author
 */
public class Customer3 {

    public static void main(String[] args) {
        try {

            //获取链接
            Connection connection = RabbitMqUtils.getConnection();

            //创建通道
            Channel channel = connection.createChannel();

            //通道绑定交换机
            channel.exchangeDeclare("logs","fanout");

            //创建临时队列
            String queueName = channel.queueDeclare().getQueue();

            //绑定交换机和队列
            channel.queueBind(queueName,"logs","");

            //消费消息
            channel.basicConsume(queueName,true,new DefaultConsumer(channel){
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    System.out.println("消费者3："+new String(body));
                }
            });


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
