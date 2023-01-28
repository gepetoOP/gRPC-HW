package question.services;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import question.QuestionGrpc;
import question.domain.QuestionMessage;
import io.grpc.stub.StreamObserver;
import question.QuestionReply;
import question.QuestionRequest;
import question.repository.QuestionRepository;

import java.time.LocalDateTime;
import java.util.UUID;


@Singleton
public class QuestionService extends QuestionGrpc.QuestionImplBase {
    @Inject
    private QuestionRepository questionRepository;

    @Override
    public void callQuestion(QuestionRequest request, StreamObserver<QuestionReply> responseObserver) {
        responseObserver.onNext(buildResponse(request));
        responseObserver.onCompleted();
    }

    private QuestionReply buildResponse(QuestionRequest request) {
        var questionMessage = QuestionMessage.builder().message(UUID.randomUUID().toString()).date(LocalDateTime.now().toString()).build();
        var resposta = request.getName() + " : " + questionMessage.getMessage();
        var response = questionRepository.save(questionMessage);
        System.out.println(response);

        return QuestionReply.newBuilder().setMessage(resposta).build();
    }
}