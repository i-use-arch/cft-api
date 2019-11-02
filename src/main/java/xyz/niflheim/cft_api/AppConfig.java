package xyz.niflheim.cft_api;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class AppConfig {
    private static final Config CONFIG = ConfigFactory.load();

    public static final String MONGO_NAME = CONFIG.getString("Mongo.name");
    public static final String MONGO_HOSTNAME = CONFIG.getString("Mongo.hostname");
    public static final String MONGO_USER = CONFIG.getString("Mongo.user");
    public static final String MONGO_PASS = System.getProperty("pass");
    public static final String MONGO_OPTIONS = CONFIG.getString("Mongo.options");

    public static final int MONGO_PORT = CONFIG.getInt("Mongo.port");
}
