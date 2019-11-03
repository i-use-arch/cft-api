package xyz.niflheim.cft_api;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import xyz.niflheim.cft_api.db.Mongo;
import xyz.niflheim.cft_api.db.util.Connection;

@SpringBootApplication
public class App {
    private static Channel channel;
    private static Mongo mongo;

    public static void main(String[] args) throws Exception {
        mongo = new Mongo(Connection.getDefault(), true);

        ConnectionFactory factory = new ConnectionFactory();
        //factory.useSslProtocol();
        factory.setPort(5672);
        factory.setHost("maple.kirbyquerby.me");
        factory.setUsername(System.getProperty("ruser"));
        factory.setPassword(System.getProperty("rpass"));

        com.rabbitmq.client.Connection conn = factory.newConnection();
        channel = conn.createChannel();
        channel.queueDeclare("submission_queue", true, false, false, null);

        SpringApplication.run(App.class, args);
    }

    public static Mongo getMongo() {
        return mongo;
    }

    public static Channel getChannel() {
        return channel;
    }
}
