package question.infra.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import question.domain.QuestionMessage;
import question.infra.repository.model.QuestionMessageDocument;

@Mapper(componentModel = "jsr330")
public interface QuestionMessageDocumentMapper {
    @Mapping(target = "date", source = "dateTime")
    @Mapping(target = "message", source = "message")
    QuestionMessageDocument toQuestionMessageDocument(QuestionMessage questionMessage);
}
