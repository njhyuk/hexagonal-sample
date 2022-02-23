package com.marketplace.product.api.adapter.in.web;

import com.marketplace.product.api.adapter.in.web.v1.model.ErrorModel;
import com.marketplace.product.api.domain.exception.ApiThrottleException;
import com.marketplace.product.api.domain.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiControllerAdvice {
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(NotFoundException.class)
  protected ErrorModel notFoundException(Throwable e) {
    return new ErrorModel(e.getMessage());
  }

  @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
  @ExceptionHandler(BindException.class)
  protected ErrorModel validationException(BindException e) {
    String message = e.getBindingResult().getFieldErrors().stream()
        .findAny()
        .map(FieldError::getDefaultMessage)
        .orElse(null);

    return new ErrorModel(message);
  }

  @ResponseStatus(HttpStatus.TOO_MANY_REQUESTS)
  @ExceptionHandler(ApiThrottleException.class)
  protected ErrorModel apiThrottleException(ApiThrottleException e) {
    return new ErrorModel(e.getMessage());
  }
}
