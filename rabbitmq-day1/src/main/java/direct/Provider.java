package direct;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import util.RabbitMqUtils;

/**
 * @author Administrator
 */
public class Provider {
    public static void main(String[] args) {

        try {

            String exchangeName = "logs_direct";

            //获取链接
            Connection connection = RabbitMqUtils.getConnection();
            //创建通道
            Channel channel = connection.createChannel();
            //声明交换机器
            channel.exchangeDeclare(exchangeName,"direct");
            //发送消息
            //声明route key
            String routingKey = "info";
            channel.basicPublish(exchangeName,routingKey,null,("这是direct类型发布的信息，并且基于route key :"+routingKey+"").getBytes());

            //关闭资源
            RabbitMqUtils.closeChancleAndConnection(channel, connection);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
