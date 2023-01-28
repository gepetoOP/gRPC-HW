package question.repository;

import org.bson.BsonValue;
import question.domain.QuestionMessage;

public interface QuestionRepository {
    BsonValue save(QuestionMessage questionMessage);
}
