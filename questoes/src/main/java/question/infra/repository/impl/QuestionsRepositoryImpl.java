package question.infra.repository.impl;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import jakarta.inject.Singleton;
import question.domain.QuestionMessage;
import question.infra.repository.QuestionRepository;
import question.infra.repository.mapper.QuestionMessageDocumentMapper;
import question.infra.repository.model.QuestionMessageDocument;

@Singleton
public class QuestionsRepositoryImpl implements QuestionRepository {
    final MongoCollection<QuestionMessageDocument> collection;
    final QuestionMessageDocumentMapper mapper;

    public QuestionsRepositoryImpl(MongoClient mongoClient, QuestionMessageDocumentMapper mapper) {
        var database = mongoClient.getDatabase("test");
        this.collection = database.getCollection("questions", QuestionMessageDocument.class);
        this.mapper = mapper;
    }

    public String save(QuestionMessage questionMessage) {
        var newDocument = mapper.toQuestionMessageDocument(questionMessage);

        var result = collection.insertOne(newDocument);

        if (result.getInsertedId() != null) {
            return result.getInsertedId().asObjectId().getValue().toString();
        }

        return null;
    }
}
