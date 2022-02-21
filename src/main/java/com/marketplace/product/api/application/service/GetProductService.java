package com.marketplace.product.api.application.service;

import com.marketplace.product.api.application.port.in.GetProductUseCase;
import com.marketplace.product.api.application.port.out.GetProductPort;
import com.marketplace.product.api.domain.Product;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
public class GetProductService implements GetProductUseCase {
  private final GetProductPort getProductPort;

  @Override
  public Product getProduct(Long productNo) {
    return getProductPort.getProduct(productNo);
  }
}
