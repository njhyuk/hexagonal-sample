package com.marketplace.product.api.application.service;

import com.marketplace.product.api.application.port.in.CreateProductCommand;
import com.marketplace.product.api.application.port.in.CreateProductUseCase;
import com.marketplace.product.api.application.port.out.CreateProductPort;
import com.marketplace.product.api.domain.Product;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
public class CreateProductService implements CreateProductUseCase {
  private final CreateProductPort createProductPort;

  @Override
  public Product createProduct(CreateProductCommand createProductCommand) {
    return createProductPort.createProduct(createProductCommand);
  }
}
