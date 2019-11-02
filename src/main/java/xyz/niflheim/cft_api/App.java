package xyz.niflheim.cft_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import xyz.niflheim.cft_api.db.Mongo;
import xyz.niflheim.cft_api.db.objects.User;
import xyz.niflheim.cft_api.db.util.Connection;

@SpringBootApplication
public class App {

    private final static String QUEUE_NAME = "hello";


    public static void main(String[] args) throws Exception {
        Mongo mongo = new Mongo(Connection.getDefault(), true, new User());

        SpringApplication.run(App.class, args);
    }
}
