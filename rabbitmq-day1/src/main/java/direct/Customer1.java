package direct;

import com.rabbitmq.client.*;
import util.RabbitMqUtils;

import java.io.IOException;

/**
 * @author Administrator
 */
public class Customer1 {

    public static void main(String[] args) {
        try {
            String exchangeName = "logs_direct";
            Connection connection = RabbitMqUtils.getConnection();
            Channel channel = connection.createChannel();
            //声明交换机，及类型
            channel.exchangeDeclare(exchangeName,"direct");
            //创建临时队列
            String queue = channel.queueDeclare().getQueue();
            //队列跟交换机绑定
            channel.queueBind(queue,exchangeName,"error");
            //消费消息
            channel.basicConsume(queue,true,new DefaultConsumer(channel){
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    System.out.println("消费者1："+new String(body));
                }
            });

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
