package com.marketplace.product.api.adapter.in.web.v1.model;

public class ErrorModel {
  private final String message;

  public ErrorModel(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
