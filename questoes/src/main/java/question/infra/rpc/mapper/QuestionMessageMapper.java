package question.infra.rpc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import question.QuestionRequest;
import question.domain.QuestionMessage;

import java.time.LocalDateTime;

@Mapper(componentModel = "jsr330", imports = LocalDateTime.class)
public interface QuestionMessageMapper {
    @Mapping(target = "message", source = "message")
    @Mapping(target = "dateTime", expression = "java(LocalDateTime.now())")
    QuestionMessage toQuestionMessage(QuestionRequest request);
}
