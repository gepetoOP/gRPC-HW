package question.infra.repository.impl;

import com.mongodb.client.MongoCollection;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import question.domain.QuestionMessage;
import question.infra.repository.QuestionRepository;
import question.infra.repository.mapper.QuestionMessageDocumentMapper;
import question.infra.repository.model.QuestionMessageDocument;

@Singleton
public class QuestionsRepositoryImpl implements QuestionRepository {
    @Inject
    MongoCollection<QuestionMessageDocument> collection;
    @Inject
    QuestionMessageDocumentMapper mapper;

    public String save(QuestionMessage questionMessage) {
        var newDocument = mapper.toQuestionMessageDocument(questionMessage);

        var result = collection.insertOne(newDocument);

        if (result.getInsertedId() != null) {
            return result.getInsertedId().asObjectId().getValue().toString();
        }

        return null;
    }
}
