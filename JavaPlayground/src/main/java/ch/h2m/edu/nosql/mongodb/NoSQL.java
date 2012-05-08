package ch.h2m.edu.nosql.mongodb;

import com.mongodb.*;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * MongoDB.java
 *
 * Created on 17.11.2011, 16:03:45
 *
 * @author Heinz Marti <heinz.marti@hslu.ch>
 */
public class NoSQL {

    Mongo mongo;
    DB db;
    DBCollection collection;

    public NoSQL() {
    }
    
    public void init(){
        createConnection("myDatabase");
        createDefaultCollection("standardCollection");
    }

    private void createConnection(String dbName) {
        try {
            mongo = new Mongo("localhost", 27017);
            db = mongo.getDB(dbName);
        } catch (UnknownHostException | MongoException e) {
            System.out.println(e);
        }
    }

    private void createDefaultCollection(String collectionName) {
        // Get collection from MongoDB, database named "yourDB"
        // if collection doesn't exists, mongoDB will create it automatically
        collection = db.getCollection(collectionName);
    }

    public void writeDocument(String id, String msg) {
        // create a document to store key and value
        BasicDBObject document = new BasicDBObject();
        document.put("id", id);
        document.put("msg", msg);

        // save it into collection named "yourCollection"
        collection.insert(document);
    }

    public List<String> getResultforId(String id) {
        // search query
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("id", id);

        // query it
        DBCursor cursor = collection.find(searchQuery);

        List<String> results = new ArrayList<>();
        // loop over the cursor and display the retrieved result
        while (cursor.hasNext()) {
            results.add(cursor.next().get("msg").toString());
        }
        return results;
    }
}
