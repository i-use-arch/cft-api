package xyz.niflheim.cft_api;

import xyz.niflheim.cft_api.db.Mongo;
import xyz.niflheim.cft_api.db.objects.User;
import xyz.niflheim.cft_api.db.util.Connection;

public class App {
    public static void main(String[] args) {
        Mongo mongo = new Mongo(Connection.getDefault(), true, new User());
    }
}
