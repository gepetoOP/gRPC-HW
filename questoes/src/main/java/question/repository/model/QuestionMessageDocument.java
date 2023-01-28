package question.repository.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.bson.Document;
import org.bson.types.ObjectId;

@Data
public class QuestionMessageDocument extends Document {
    @JsonProperty("_id")
    private ObjectId id = new ObjectId();
    private String message;
    private String date;

    public Document toDocument() {
        return new Document()
                .append("_id", this.getId())
                .append("message", this.getMessage())
                .append("date", this.getDate());
    }
}
