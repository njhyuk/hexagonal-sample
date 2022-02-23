package com.marketplace.product.api.domain.exception;

public class ApiThrottleException extends RuntimeException {
  private final static String MESSAGE = "비정상적인 API 호출이 감지 되었습니다.";

  public ApiThrottleException() {
    super(MESSAGE);
  }
}
