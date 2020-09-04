package helloWorld;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;
import org.junit.Test;
import util.RabbitMqUtils;

import java.io.IOException;

/**
 * @author Administrator
 */
public class Provider {

    //生成消息
    @Test
    public  void testSendMessage(){
        try {
//            //创建链接mq的链接工厂
//            ConnectionFactory connectionFactory = new ConnectionFactory();
//
//            //设置链接主机
//            connectionFactory.setHost("47.102.150.239");
//            //设置端口
//            connectionFactory.setPort(5672);
//            //设置Ribbitmq 的仓库
//            connectionFactory.setVirtualHost("/ems");
//            //用户名  密码
//            connectionFactory.setUsername("ems");
//            connectionFactory.setPassword("123");
//
//            //获取链接对象
//            Connection connection = connectionFactory.newConnection();

            Connection connection = RabbitMqUtils.getConnection();
            //获取通道
            Channel channel = connection.createChannel();

            //消息队列与通道绑定
            //参数1：队列名称；如果没有则会自动创建
            //参数2：用来定义队列特性是否要持久化，true：持久化  false：不持久化
            //参数3：exclusive :是否独占队列  true:是，false:不是
            //参数4：autoDelte:是否在消费完后删除队列   true:是；false ： 不是
            //参数5：额外附加参数
            channel.queueDeclare("hello",true,false,false,null);

            //发布消息
            //参数1：交换机名称  参数2：队列名称  参数3：传递消息的额外设置  参数4：消息的具体内容
            channel.basicPublish("","hello", MessageProperties.PERSISTENT_TEXT_PLAIN,"hello rabittmq".getBytes());


//            channel.close();
//            connection.close();
            RabbitMqUtils.closeChancleAndConnection(channel,connection);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
