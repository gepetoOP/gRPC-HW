package question.infra.mapper.repository;

import question.domain.QuestionMessage;

public interface QuestionRepository {
    String save(QuestionMessage questionMessage);
}
