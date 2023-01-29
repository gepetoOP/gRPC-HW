package question.infra.mapper.repository.impl;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import jakarta.inject.Singleton;
import question.domain.QuestionMessage;
import question.infra.mapper.repository.QuestionRepository;
import question.infra.mapper.repository.model.QuestionMessageDocument;

@Singleton
public class QuestionsRepositoryImpl implements QuestionRepository {
    final MongoCollection<QuestionMessageDocument> collection;

    public QuestionsRepositoryImpl(MongoClient mongoClient) {
        var database = mongoClient.getDatabase("test");
        this.collection = database.getCollection("questions", QuestionMessageDocument.class);
    }

    public String save(QuestionMessage questionMessage) {
        var newDocument = new QuestionMessageDocument();
        newDocument.setDate(questionMessage.getDate());
        newDocument.setMessage(questionMessage.getMessage());

        var result = collection.insertOne(newDocument);

        if (result.getInsertedId() != null) {
            return result.getInsertedId().asObjectId().getValue().toString();
        }

        return null;
    }
}
