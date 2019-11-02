package xyz.niflheim.cft_api.db.objects;

import xyz.niflheim.cft_api.db.annotation.Collection;

@Collection(table = "Users")
public class User extends DataObject {
    private String name;

    public User() {
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }
}
