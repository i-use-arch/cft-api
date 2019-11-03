package xyz.niflheim.cft_api.db.objects;

import xyz.niflheim.cft_api.db.annotation.Collection;

@Collection(table = "Users")
public class User extends DataObject {
    private String username;
    private String name;
    private int planted = 0;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public int getPlanted() {
        return planted;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public User setPlanted(int planted) {
        this.planted = planted;
        return this;
    }
}
