package fanout;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import util.RabbitMqUtils;

/**
 * @author authorizing
 */
public class Provider {


    public static void main(String[] args) {

        try {

            //获取链接
            Connection connection = RabbitMqUtils.getConnection();

            //获取通道
            Channel channel = connection.createChannel();

            //将通道与交换机绑定
            //参数1：交换机名称  参数2：交换机AMQP的消息模型  fonout :广播
            channel.exchangeDeclare("logs","fanout");

            //发送消息
            channel.basicPublish("logs","",null,"fonout message type".getBytes());

            //关闭资源
            RabbitMqUtils.closeChancleAndConnection(channel,connection);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
