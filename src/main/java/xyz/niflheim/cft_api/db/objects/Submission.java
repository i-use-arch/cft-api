package xyz.niflheim.cft_api.db.objects;

import xyz.niflheim.cft_api.db.annotation.Collection;

@Collection(table = "Submissions")
public class Submission extends DataObject {
    private String user;
    private String code;

    public Submission() {
    }

    public String getUser() {
        return user;
    }

    public String getCode() {
        return code;
    }

    public Submission setUser(String user) {
        this.user = user;
        return this;
    }

    public Submission setCode(String code) {
        this.code = code;
        return this;
    }
}
