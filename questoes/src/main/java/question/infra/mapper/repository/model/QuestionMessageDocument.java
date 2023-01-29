package question.infra.mapper.repository.model;

import lombok.Data;
import org.bson.Document;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

@Data
public class QuestionMessageDocument {
    @BsonProperty(value = "_id")
    private ObjectId id = new ObjectId();

    @BsonProperty(value = "message")
    private String message;

    @BsonProperty(value = "date")
    private String date;

    public Document toDocument() {
        return new Document()
                .append("_id", this.getId())
                .append("message", this.getMessage())
                .append("date", this.getDate());
    }
}