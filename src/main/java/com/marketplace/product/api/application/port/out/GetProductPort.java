package com.marketplace.product.api.application.port.out;

import com.marketplace.product.api.domain.Product;

public interface GetProductPort {
  Product getProduct(Long productNo);
}
