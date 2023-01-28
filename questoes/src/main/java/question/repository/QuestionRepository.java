package question.repository;

import org.bson.BsonValue;
import question.domain.QuestionMessage;

public interface QuestionRepository {
    String save(QuestionMessage questionMessage);
}
