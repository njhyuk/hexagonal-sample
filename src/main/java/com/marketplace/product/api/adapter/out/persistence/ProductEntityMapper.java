package com.marketplace.product.api.adapter.out.persistence;

import com.marketplace.product.api.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductEntityMapper {
  protected Product bind(ProductEntity entity) {
    return Product.builder()
        .productNo(entity.getProductNo())
        .name(entity.getName())
        .contents(entity.getContents())
        .companyId(entity.getCompanyId())
        .createDateTime(entity.getCreateDateTime())
        .updateDateTime(entity.getUpdateDateTime())
        .build();
  }
}
