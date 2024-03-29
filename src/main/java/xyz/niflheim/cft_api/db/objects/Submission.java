package xyz.niflheim.cft_api.db.objects;

public class Submission extends DataObject {
    private String user;
    private String code;
    private String lang;
    private String output;
    private String status;

    public Submission() {
    }

    public String getUser() {
        return user;
    }

    public String getCode() {
        return code;
    }

    public String getLang() {
        return lang;
    }

    public String getOutput() {
        return output;
    }

    public String getStatus() {
        return status;
    }

    public Submission setUser(String user) {
        this.user = user;
        return this;
    }

    public Submission setCode(String code) {
        this.code = code;
        return this;
    }

    public Submission setLang(String lang) {
        this.lang = lang;
        return this;
    }

    public Submission setOutput(String output) {
        this.output = output;
        return this;
    }

    public Submission setStatus(String status) {
        this.status = status;
        return this;
    }
}
