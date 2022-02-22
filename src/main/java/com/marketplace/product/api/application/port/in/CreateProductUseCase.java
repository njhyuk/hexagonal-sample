package com.marketplace.product.api.application.port.in;

import com.marketplace.product.api.domain.Product;

public interface CreateProductUseCase {
  Product createProduct(CreateProductCommand createProductCommand);
}
