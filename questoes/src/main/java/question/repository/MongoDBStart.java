package question.repository;


import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.slf4j.LoggerFactory;

import java.util.logging.Logger;

public class MongoDBStart {
    public static void main( String[] args ) {
        String uri = "uri";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            var logger = LoggerFactory.getLogger(MongoDBStart.class);
            MongoDatabase database = mongoClient.getDatabase("test");
            MongoCollection<Document> collection = database.getCollection("questions");
            Document doc = collection.find(eq("message", "Hello World")).first();
            if (doc != null) {
                logger.info(doc.toJson());
            } else {
                logger.info("No matching documents found.");
            }
        }
    }
}