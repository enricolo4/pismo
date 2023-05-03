package com.pismo.config;

import com.pismo.exceptions.TransactionNotExecutedException;
import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import io.micronaut.http.server.exceptions.response.ErrorContext;
import io.micronaut.http.server.exceptions.response.ErrorResponseProcessor;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Produces
@Singleton
@Requires(
    classes = {
        TransactionNotExecutedException.class,
        ExceptionHandler.class
    }
)
public class TransactionNotExecutedExceptionHandler implements ExceptionHandler<TransactionNotExecutedException, HttpResponse<?>> {

    @Inject
    private ErrorResponseProcessor errorResponseProcessor;

    @Override
    public HttpResponse<?> handle(HttpRequest request, TransactionNotExecutedException exception) {
        return errorResponseProcessor.processResponse(
            ErrorContext.builder(request)
                .cause(exception)
                .errorMessage(exception.getMessage())
                .build(),
            HttpResponse.unprocessableEntity()
        );
    }
}
