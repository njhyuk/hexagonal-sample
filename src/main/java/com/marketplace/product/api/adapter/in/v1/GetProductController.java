package com.marketplace.product.api.adapter.in.v1;

import com.marketplace.product.api.adapter.in.v1.model.ProductDetailModel;
import com.marketplace.product.api.application.port.in.GetProductUseCase;
import com.marketplace.product.api.domain.Product;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class GetProductController {
  private final GetProductUseCase getProductUseCase;

  @GetMapping("/v1/products/{productNo}")
  public ProductDetailModel getProduct(@PathVariable Long productNo) {
    Product product = getProductUseCase.getProduct(productNo);

    return ProductDetailModel.from(product);
  }
}
