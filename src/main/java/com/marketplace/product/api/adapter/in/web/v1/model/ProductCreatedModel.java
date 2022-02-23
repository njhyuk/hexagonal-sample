package com.marketplace.product.api.adapter.in.web.v1.model;

public class ProductCreatedModel {
  private final Long productNo;

  public ProductCreatedModel(Long productNo) {
    this.productNo = productNo;
  }

  public Long getProductNo() {
    return productNo;
  }
}
