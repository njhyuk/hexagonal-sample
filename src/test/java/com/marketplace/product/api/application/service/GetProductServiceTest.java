package com.marketplace.product.api.application.service;

import com.marketplace.product.api.application.port.out.GetProductPort;
import com.marketplace.product.api.domain.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class GetProductServiceTest {
  @Test
  @DisplayName("상품 상세 데이터를 가져온다")
  void getProduct() {
    GetProductPort getProductPort = productNo -> Product.builder()
        .productNo(1L)
        .name("릴렉스드 베이식 블레이저 [블랙]")
        .contents("<img src=\"//image.musinsa.com/images/prd_img/2021032911161200000086392.jpg\">")
        .companyId("musinsa")
        .createDateTime(LocalDateTime.now())
        .updateDateTime(LocalDateTime.now())
        .build();

    GetProductService getProductService = new GetProductService(getProductPort);
    Product product = getProductService.getProduct(1L);

    assertThat(product.getProductNo()).isEqualTo(1L);
    assertThat(product.getName()).isEqualTo("릴렉스드 베이식 블레이저 [블랙]");
  }
}
