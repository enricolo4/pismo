package com.pismo.config;

import com.pismo.exceptions.TransactionNotFoundException;
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
        TransactionNotFoundException.class,
        ExceptionHandler.class
    }
)
public class TransactionNotFoundExceptionHandler implements ExceptionHandler<TransactionNotFoundException, HttpResponse<?>> {

    @Inject
    private ErrorResponseProcessor errorResponseProcessor;

    @Override
    public HttpResponse<?> handle(HttpRequest request, TransactionNotFoundException exception) {
        return errorResponseProcessor.processResponse(
            ErrorContext.builder(request)
                .cause(exception)
                .errorMessage(exception.getMessage())
                .build(),
            HttpResponse.notFound()
        );
    }
}
