package question.infra.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import question.QuestionRequest;
import question.domain.QuestionMessage;

import java.time.LocalDateTime;

@Mapper(componentModel = "jsr330", imports = LocalDateTime.class)
public interface QuestionMessageMapper {
    @Mapping(target = "message", source = "name")
    @Mapping(target = "date", expression = "java(LocalDateTime.now().toString())")
    QuestionMessage toQuestionMessage(String name);
}
