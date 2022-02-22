package com.marketplace.product.api.adapter.in.v1.model;

import com.marketplace.product.api.domain.Product;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class ProductDetailModel {
  private Long productNo;
  private String name;
  private String contents;
  private String companyId;
  private LocalDateTime createDateTime;
  private LocalDateTime updateDateTime;

  public static ProductDetailModel from(Product product) {
    return ProductDetailModel.builder()
        .productNo(product.getProductNo())
        .name(product.getName())
        .contents(product.getContents())
        .companyId(product.getCompanyId())
        .createDateTime(product.getCreateDateTime())
        .updateDateTime(product.getUpdateDateTime())
        .build();
  }
}
