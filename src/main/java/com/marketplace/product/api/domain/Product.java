package com.marketplace.product.api.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class Product {
  private Long productNo;
  private String name;
  private String contents;
  private String companyId;
  private LocalDateTime createDateTime;
  private LocalDateTime updateDateTime;
}
