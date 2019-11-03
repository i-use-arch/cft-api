package xyz.niflheim.cft_api.db.objects;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonIgnore;
import xyz.niflheim.cft_api.db.util.Snowflake;

public abstract class DataObject {
    @BsonIgnore
    private boolean exist = true;
    @BsonId
    private long id;

    public DataObject() {
        this.id = Snowflake.get();
        this.exist = false;
    }

    public long getId() {
        return id;
    }

    public DataObject setId(long id) {
        this.id = id;
        return this;
    }

    public boolean isExist() {
        return exist;
    }

    public DataObject setExist(boolean exist) {
        this.exist = exist;
        return this;
    }
}
