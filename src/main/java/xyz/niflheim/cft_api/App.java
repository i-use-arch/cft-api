package xyz.niflheim.cft_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import xyz.niflheim.cft_api.db.Mongo;
import xyz.niflheim.cft_api.db.objects.User;
import xyz.niflheim.cft_api.db.util.Connection;
import xyz.niflheim.cft_api.queue.RQueue;

@SpringBootApplication
public class App {

    private final static String QUEUE_NAME = "hello";


    public static void main(String[] args) throws Exception {
        Mongo mongo = new Mongo(Connection.getDefault(), true, new User());

        SpringApplication.run(App.class, args);

//        RQueue workQueue = new RQueue("localhost", "test");
//
//        workQueue.sendMessage("hello, world");
//
//        workQueue.registerDeliverCallback(((consumerTag, message) -> {
//            String response = new String(message.getBody(), "UTF-8");
//            System.out.println("Recieved message from work queue " + message);
//        }));
    }
}
