package Remote.MOM;

import com.rabbitmq.client.*;

public class RabbitMQUtil {
    private static final String QUEUE_NAME = "mvc_queue";
    private static Connection connection;
    private static Channel channel;

    public static void setup() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        connection = factory.newConnection();
        channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
    }

    public static void sendMessage(String message) throws Exception {
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
    }

    public static void consumeMessages(DeliverCallback deliverCallback) throws Exception {
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {});
    }

    public static void close() throws Exception {
        channel.close();
        connection.close();
    }
}
