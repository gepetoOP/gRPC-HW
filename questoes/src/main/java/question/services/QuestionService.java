package question.services;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import question.QuestionGrpc;
import question.domain.QuestionMessage;
import io.grpc.stub.StreamObserver;
import question.QuestionReply;
import question.QuestionRequest;
import question.infra.mapper.QuestionMessageMapper;
import question.repository.QuestionRepository;

import java.time.LocalDateTime;


@Singleton
public class QuestionService extends QuestionGrpc.QuestionImplBase {
    @Inject
    private QuestionRepository questionRepository;
    @Inject
    private QuestionMessageMapper questionMessageMapper;

    @Override
    public void callQuestion(QuestionRequest request, StreamObserver<QuestionReply> responseObserver) {
        responseObserver.onNext(buildResponse(request));
        responseObserver.onCompleted();
    }

    private QuestionReply buildResponse(QuestionRequest request) {
        var questionMessage = questionMessageMapper.toQuestionMessage(request.getName());

        var response = questionRepository.save(questionMessage);

        return QuestionReply.newBuilder().setMessage(response).build();
    }
}