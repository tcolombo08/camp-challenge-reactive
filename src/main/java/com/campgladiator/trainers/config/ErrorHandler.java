package com.campgladiator.trainers.config;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import com.campgladiator.trainers.exception.EntityNotFoundException;
import com.mongodb.DuplicateKeyException;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;
import reactor.core.publisher.Mono;

@Component
@Order(-2)
public class ErrorHandler implements WebExceptionHandler {

  @Override
  public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
    if (ex instanceof EntityNotFoundException) {
      exchange.getResponse().setStatusCode(NOT_FOUND);

      // marks the response as complete and forbids writing to it
      return exchange.getResponse().setComplete();
    }
    if (ex instanceof DuplicateKeyException) {
      exchange.getResponse().setStatusCode(BAD_REQUEST);

      // marks the response as complete and forbids writing to it
      return exchange.getResponse().setComplete();
    }
    return Mono.error(ex);
  }
}
