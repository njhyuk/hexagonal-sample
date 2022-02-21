package com.marketplace.product.api.adapter.out.persistence;

import com.marketplace.product.api.application.port.out.GetProductPort;
import com.marketplace.product.api.domain.Product;
import com.marketplace.product.api.domain.exception.NotExistProductException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class ProductRepositoryAdapter implements GetProductPort {
  private final ProductRepository productRepository;
  private final ProductEntityMapper productMapper;

  @Override
  public Product getProduct(Long productNo) {
    ProductEntity productEntity = productRepository.findById(productNo)
        .orElseThrow(() -> new NotExistProductException(productNo));

    return productMapper.bind(productEntity);
  }
}
