package question.infra.repository.model;

import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;

@Data
public class QuestionMessageDocument {
    @BsonProperty(value = "_id")
    private ObjectId id;

    @BsonProperty(value = "message")
    private String message;

    @BsonProperty(value = "date")
    private LocalDateTime date;
}
