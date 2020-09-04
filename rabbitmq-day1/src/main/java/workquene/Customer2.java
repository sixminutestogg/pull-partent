package workquene;

import com.rabbitmq.client.*;
import util.RabbitMqUtils;

import java.io.IOException;

/**
 * @author a
 */
public class Customer2 {

    public static void main(String[] args) {
        try {

            //获取链接
            Connection connection = RabbitMqUtils.getConnection();
            //获取通道
            Channel channel = connection.createChannel();

            //通道 队列绑定
            channel.queueDeclare("work",true,false,false,null);

            //接收消息
            channel.basicConsume("work",true,new DefaultConsumer(channel){
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    System.out.println("消费者-2消费："+new String(body));
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
