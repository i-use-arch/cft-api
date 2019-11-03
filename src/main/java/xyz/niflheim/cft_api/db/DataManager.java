package xyz.niflheim.cft_api.db;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.ReplaceOptions;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.niflheim.cft_api.AppConfig;
import xyz.niflheim.cft_api.db.objects.*;
import xyz.niflheim.cft_api.db.util.Connection;

import java.util.HashMap;
import java.util.Map;

import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

@SuppressWarnings("unchecked")
public abstract class DataManager {
    protected final Logger LOG = LoggerFactory.getLogger(DataManager.class);
    protected Map<Class, String> classToCollection = new HashMap<>();
    protected ReplaceOptions options = new ReplaceOptions().upsert(true);
    protected MongoClient client;
    protected MongoDatabase database;
    protected CodecRegistry codec;

    {
        classToCollection.put(User.class, "Users");
        classToCollection.put(Problem.class, "Problems");
        classToCollection.put(Case.class, "Cases");
        classToCollection.put(Submission.class, "Submissions");
    }

    protected DataManager() {
        this(Connection.getDefault(), false);
    }

    protected DataManager(Connection conn, boolean cloud) {
        LOG.info("Authenticating Mongo connection on " + conn.getHostname() + ":" + conn.getPort() + "/" + AppConfig.MONGO_NAME);
        StringBuilder cstr = new StringBuilder("mongodb");

        if (cloud)
            cstr.append("+srv");

        cstr.append("://");

        if (!conn.getUser().isEmpty() && !conn.getUser().isEmpty())
            cstr.append(conn.getUser()).append(":").append(conn.getPass()).append("@");

        cstr.append(conn.getHostname());

        if (cloud)
            cstr.append("/").append(conn.getOptions());
        else
            cstr.append(conn.getHostname()).append(":").append(conn.getPort()).append("/").append(AppConfig.MONGO_NAME);

        client = MongoClients.create(cstr.toString());
        codec = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        database = client.getDatabase(AppConfig.MONGO_NAME).withCodecRegistry(codec);
    }

    protected <T extends DataObject> T get(long id, Class<T> type) {
        return (T) getCollection(type).find(eq("_id", id)).first();
    }

    protected <T extends DataObject> T getByField(String field, String value, Class<T> type) {
        return (T) getCollection(type).find(eq(field, value)).first();
    }

    protected <T extends DataObject> void insert(T object) {
        getCollection(object.getClass()).insertOne(object);
    }

    protected <T extends DataObject> void update(long id, T object) {
        getCollection(object.getClass()).replaceOne(eq("_id", id), object, options);
    }

    protected <T extends DataObject> void delete(long id, Class<T> type) {
        getCollection(type).deleteOne(eq("_id", id));
    }

    private <T extends DataObject> MongoCollection getCollection(Class<T> type) {
        assertNotEmpty();
        return database.getCollection(classToCollection.get(type), type);
    }

    private void assertNotEmpty() {
        if (classToCollection.isEmpty())
            throw new RuntimeException("Mongo was initialized without any data mappings.");
    }
}
