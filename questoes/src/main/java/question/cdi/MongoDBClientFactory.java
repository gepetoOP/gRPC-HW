package question.cdi;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Requires;
import io.micronaut.context.annotation.Value;
import jakarta.inject.Singleton;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.jsr310.LocalDateTimeCodec;
import org.bson.codecs.pojo.PojoCodecProvider;
import question.infra.repository.model.QuestionMessageDocument;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

@Factory
public class MongoDBClientFactory {
    @Bean
    @Singleton
    public MongoClient mongoClient(@Value("${mongo.uri}") String mongoUri) {
        var connectionString = new ConnectionString(mongoUri);
        var codecRegistryFromCodecs = CodecRegistries.fromCodecs(new LocalDateTimeCodec());
        var pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        var codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry, codecRegistryFromCodecs);

        var settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .serverApi(ServerApi.builder()
                        .version(ServerApiVersion.V1)
                        .build())
                .codecRegistry(codecRegistry)
                .build();

        return MongoClients.create(settings);
    }

    @Bean
    @Singleton
    @Requires(classes = MongoClient.class)
    public MongoCollection<QuestionMessageDocument> questionMessageDocumentMongoCollection(MongoClient mongoClient) {
        var database = mongoClient.getDatabase("test");

        return database.getCollection("questions", QuestionMessageDocument.class);
    }
}
