package workquene;

import com.rabbitmq.client.*;
import util.RabbitMqUtils;

import java.io.IOException;

/**
 * @author a
 */
public class Customer1 {

    public static void main(String[] args) {
        try {

            //获取链接
            Connection connection = RabbitMqUtils.getConnection();
            //获取通道
             final Channel channel = connection.createChannel();

            //通道 队列绑定
            channel.queueDeclare("work",true,false,false,null);

            //设置一次消费消息的条数
            channel.basicQos(1);

            //接收消息
            channel.basicConsume("work",false,new DefaultConsumer(channel){
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                   try {
                       //睡5秒
                       Thread.sleep(5000);
                   }catch (Exception e){
                       e.printStackTrace();
                   }

                    System.out.println("消费者-1消费："+new String(body));
                    //手动确认消费消息
                    //参数1；手动确认的消息标识  参数2：false为每次只确认一个
                    channel.basicAck(envelope.getDeliveryTag(),false);
                }

            });



        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
