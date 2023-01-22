package question.services;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import question.QuestionGrpc;
import question.QuestionMessage;
import io.grpc.stub.StreamObserver;
import question.QuestionReply;
import question.QuestionRequest;


@Singleton
public class QuestionService extends QuestionGrpc.QuestionImplBase {
    @Inject
    private QuestionMessage questionMessage;

    @Override
    public void callQuestion(QuestionRequest request, StreamObserver<QuestionReply> responseObserver) {
        responseObserver.onNext(buildResponse(request));
        responseObserver.onCompleted();
    }

    private QuestionReply buildResponse(QuestionRequest request) {
        var resposta = request.getName() + " : " + questionMessage.retornaFrase();

        return QuestionReply.newBuilder().setMessage(resposta).build();
    }
}