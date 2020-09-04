package util;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author  z
 */
public class RabbitMqUtils {

    private  static  ConnectionFactory connectionFactory;

    private  static  String host ="47.102.150.239";

    private  static int port =5672;

    private  static  String virtualHost = "/ems";

    private  static  String userName = "ems";


    private static   String passWord ="123";




    //静态代码块类加载
    static {
        connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(host);
        connectionFactory.setPort(port);
        connectionFactory.setVirtualHost(virtualHost);
        connectionFactory.setUsername(userName);
        connectionFactory.setPassword(passWord);
    }

    /**
     * @deprecated ：获取链接
     *
     */
    public static Connection getConnection(){
        try {
            return connectionFactory.newConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
        return  null;

    }


    /**
     * @deprecated ：关闭链接
     *
     */
    public static  void closeChancleAndConnec(Channel channel , Connection connection){

        try {
            if(channel!=null){
                channel.close();
            }
            if(connection!=null) {
                connection.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
