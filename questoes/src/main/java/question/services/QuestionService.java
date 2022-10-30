package question.services;

import question.QuestionGrpc;
import question.QuestionMessage;
import io.grpc.stub.StreamObserver;
import question.QuestionReply;
import question.QuestionRequest;

import javax.inject.Singleton;

@Singleton
public class QuestionService extends QuestionGrpc.QuestionImplBase {
    @Override
    public void callQuestion(QuestionRequest request, StreamObserver<QuestionReply> responseObserver) {
        responseObserver.onNext(buildResponse(request));
        responseObserver.onCompleted();
    }

    private static QuestionReply buildResponse(QuestionRequest request) {
        var resposta = request.getName() + " : " + new QuestionMessage().retornaFrase();

        return QuestionReply.newBuilder().setMessage(resposta).build();
    }
}