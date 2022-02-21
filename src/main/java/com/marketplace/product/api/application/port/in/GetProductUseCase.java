package com.marketplace.product.api.application.port.in;

import com.marketplace.product.api.domain.Product;

public interface GetProductUseCase {
  Product getProduct(Long productNo);
}
