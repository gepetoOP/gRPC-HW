package question.repository.impl;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import jakarta.inject.Singleton;
import org.bson.BsonValue;
import org.bson.Document;
import org.bson.types.ObjectId;
import question.domain.QuestionMessage;
import question.repository.QuestionRepository;
import question.repository.model.QuestionMessageDocument;

@Singleton
public class QuestionsRepositoryImpl implements QuestionRepository {
    final MongoCollection<QuestionMessageDocument> collection;

    public QuestionsRepositoryImpl(MongoClient mongoClient) {
        var database = mongoClient.getDatabase("test");
        this.collection = database.getCollection("questions", QuestionMessageDocument.class);
    }

    public BsonValue save(QuestionMessage questionMessage) {
        var newDocument = new QuestionMessageDocument();
        newDocument.setDate(questionMessage.getDate());
        newDocument.setMessage(questionMessage.getMessage());

        var result = collection.insertOne(newDocument);

        return result.getInsertedId();
    }
}
