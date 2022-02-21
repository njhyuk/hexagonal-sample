package com.marketplace.product.api.domain.exception;

public class NotExistProductException extends RuntimeException {
  private final Long productNo;

  public NotExistProductException(Long productNo) {
    this.productNo = productNo;
  }
}
