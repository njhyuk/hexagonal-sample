package com.marketplace.product.api.application.service;

import com.marketplace.product.api.application.port.in.CreateProductCommand;
import com.marketplace.product.api.application.port.out.CreateProductPort;
import com.marketplace.product.api.domain.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class CreateProductServiceTest {
  @Test
  @DisplayName("상품을 생성한다")
  void createProduct() {
    CreateProductPort createProductPort = productNo -> Product.builder()
        .productNo(1L)
        .name("릴렉스드 베이식 블레이저 [블랙]")
        .contents("<img src=\"//image.musinsa.com/images/prd_img/2021032911161200000086392.jpg\">")
        .companyId("musinsa")
        .createDateTime(LocalDateTime.now())
        .updateDateTime(LocalDateTime.now())
        .build();

    CreateProductService createProductService = new CreateProductService(createProductPort);
    Product product = createProductService.createProduct(new CreateProductCommand(
        "릴렉스드 베이식 블레이저 [블랙]",
        "<img src=\"//image.musinsa.com/images/prd_img/2021032911161200000086392.jpg\">",
        "musinsa"
    ));

    assertThat(product.getProductNo()).isEqualTo(1L);
    assertThat(product.getName()).isEqualTo("릴렉스드 베이식 블레이저 [블랙]");
  }
}
