package com.marketplace.product.api.adapter.out.persistence;

import com.marketplace.product.api.application.port.in.CreateProductCommand;
import com.marketplace.product.api.application.port.out.CreateProductPort;
import com.marketplace.product.api.application.port.out.GetProductPort;
import com.marketplace.product.api.domain.Product;
import com.marketplace.product.api.domain.exception.NotExistProductException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
@AllArgsConstructor
public class ProductRepositoryAdapter implements GetProductPort, CreateProductPort {
  private final ProductRepository productRepository;
  private final ProductEntityMapper productMapper;

  @Override
  public Product getProduct(Long productNo) {
    ProductEntity productEntity = productRepository.findById(productNo)
        .orElseThrow(() -> new NotExistProductException(productNo));

    return productMapper.bind(productEntity);
  }

  @Override
  public Product createProduct(CreateProductCommand command) {
    ProductEntity productEntity = productRepository.save(
        ProductEntity.builder()
            .name(command.getName())
            .contents(command.getContents())
            .companyId(command.getCompanyId())
            .createDateTime(LocalDateTime.now())
            .build()
    );
    
    return productMapper.bind(productEntity);
  }
}
