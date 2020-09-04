package workquene;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;
import util.RabbitMqUtils;

/**
 * @author Administrator
 * 工作队列 的 生产者
 */
public class Provider {

    public static void main(String[] args) {
        try {

            //获取对象
            Connection connection = RabbitMqUtils.getConnection();
            
            //获取通道
            Channel channel = connection.createChannel();

            //通道绑定队列
            channel.queueDeclare("work",true,false,false,null);

            //发送消息
            for (int i =1 ;i<=100 ; i++){

                channel.basicPublish("","work", MessageProperties.PERSISTENT_TEXT_PLAIN,("第"+i+"次的 work queuen ! 的消息").getBytes());
            }

            RabbitMqUtils.closeChancleAndConnection(channel,connection);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
