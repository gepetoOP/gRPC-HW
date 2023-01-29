package question.infra.repository.mapper;

import org.mapstruct.Mapper;
import question.domain.QuestionMessage;
import question.infra.repository.model.QuestionMessageDocument;

@Mapper(componentModel = "jsr330")
public interface QuestionMessageDocumentMapper {
    QuestionMessageDocument toQuestionMessageDocument(QuestionMessage questionMessage);
}
