package com.marketplace.product.api.domain.exception;

public class NotExistProductException extends NotFoundException {
  public NotExistProductException(Long productNo) {
    super(String.format("%s번 상품은 존재하지 않은 상품입니다.", productNo));
  }
}
