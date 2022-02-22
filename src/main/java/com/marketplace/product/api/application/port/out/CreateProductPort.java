package com.marketplace.product.api.application.port.out;

import com.marketplace.product.api.application.port.in.CreateProductCommand;
import com.marketplace.product.api.domain.Product;

public interface CreateProductPort {
  Product createProduct(CreateProductCommand command);
}
