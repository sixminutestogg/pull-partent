package topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import util.RabbitMqUtils;

public class Provider {

    public static void main(String[] args) {
        try {
            Connection connection = RabbitMqUtils.getConnection();
            Channel channel = connection.createChannel();

            channel.exchangeDeclare("topics","topic");

            String routeKey = "user.save.delete";

            channel.basicPublish("topics",routeKey,null,("这个是动态路由topic的消息，routeKey是："+routeKey).getBytes());

            RabbitMqUtils.closeChancleAndConnection(channel, connection);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
