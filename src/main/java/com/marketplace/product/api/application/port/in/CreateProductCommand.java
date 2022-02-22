package com.marketplace.product.api.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateProductCommand {
  private final String name;
  private final String contents;
  private final String companyId;
}
