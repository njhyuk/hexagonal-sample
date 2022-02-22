package com.marketplace.product.api.adapter.in.v1.model;

import com.marketplace.product.api.domain.Product;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProductCreatedModel {
  private Long productNo;

  public static ProductCreatedModel from(Product product) {
    return ProductCreatedModel.builder()
        .productNo(product.getProductNo())
        .build();
  }
}
