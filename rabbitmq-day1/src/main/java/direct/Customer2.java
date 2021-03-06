package direct;

import com.rabbitmq.client.*;
import util.RabbitMqUtils;

import java.io.IOException;

/**
 * @author Administrator
 */
public class Customer2 {
    public static void main(String[] args) {
        try {
            String exchangeName = "logs_direct";

            Connection connection = RabbitMqUtils.getConnection();
            Channel channel = connection.createChannel();
            channel.exchangeDeclare(exchangeName,"direct");
            String queue = channel.queueDeclare().getQueue();

            channel.queueBind(queue,exchangeName,"error");
            channel.queueBind(queue,exchangeName,"warning");
            channel.queueBind(queue,exchangeName,"info");

            channel.basicConsume(queue,true,new DefaultConsumer(channel){
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    System.out.println("消费者2："+new String(body));
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
