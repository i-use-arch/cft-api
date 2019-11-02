package xyz.niflheim.cft_api.db.util;

import org.springframework.lang.Nullable;
import xyz.niflheim.cft_api.AppConfig;

public class Connection {
    private String hostname;
    private String user;
    private String pass;
    private String options;

    private int port;

    private Connection(@Nullable String hostname, int port, @Nullable String user, @Nullable String pass, @Nullable String options) {
        this.hostname = hostname == null ? AppConfig.MONGO_HOSTNAME : hostname;
        this.user = user == null ? AppConfig.MONGO_USER : user;
        this.pass = pass == null ? AppConfig.MONGO_PASS : pass;
        this.options = options == null ? AppConfig.MONGO_OPTIONS : options;

        this.port = port == -1 ? AppConfig.MONGO_PORT : port;
    }

    public String getHostname() {
        return hostname;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public String getOptions() {
        return options;
    }

    public int getPort() {
        return port;
    }

    public static Connection getDefault() {
        return of(null, -1, null, null, null);
    }

    public static Connection of(String hostname, int port, String user, String pass, String options) {
        return new Connection(hostname, port, user, pass, options);
    }
}
