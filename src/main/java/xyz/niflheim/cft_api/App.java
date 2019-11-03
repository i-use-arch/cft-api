package xyz.niflheim.cft_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import xyz.niflheim.cft_api.db.Mongo;
import xyz.niflheim.cft_api.db.objects.Case;
import xyz.niflheim.cft_api.db.objects.Problem;
import xyz.niflheim.cft_api.db.objects.Submission;
import xyz.niflheim.cft_api.db.objects.User;
import xyz.niflheim.cft_api.db.util.Connection;

@SpringBootApplication
public class App {
    private static Mongo mongo;

    public static void main(String[] args) throws Exception {
        mongo = new Mongo(Connection.getDefault(), true);

        SpringApplication.run(App.class, args);
    }

    public static Mongo getMongo() {
        return mongo;
    }
}
