package xyz.niflheim.cft_api.db;

import xyz.niflheim.cft_api.db.objects.DataObject;
import xyz.niflheim.cft_api.db.objects.User;
import xyz.niflheim.cft_api.db.util.Connection;

public class Mongo extends DataManager {
    public Mongo() {
        super();
    }

    public Mongo(Connection conn, boolean cloud, DataObject... objects) {
        super(conn, cloud);
        setMappings(objects);
    }

    public User getUser(long id) {
        return get(id, User.class);
    }

    public void updateUser(User user) {
        update(user.getId(), user);
    }

    public void deleteUser(User user) {
        delete(user.getId(), User.class);
    }
}
