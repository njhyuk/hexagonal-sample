package com.marketplace.product.api.adapter.in.web.v1;

import com.marketplace.product.api.adapter.in.web.v1.model.ProductCreatedModel;
import com.marketplace.product.api.application.port.in.CreateProductCommand;
import com.marketplace.product.api.application.port.in.CreateProductUseCase;
import com.marketplace.product.api.domain.Product;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class CreateProductController {
  private final CreateProductUseCase createProductUseCase;

  @PostMapping("/v1/products")
  public ProductCreatedModel createProduct(
      @RequestBody @Valid CreateProductCommand createProductCommand
  ) {
    Product product = createProductUseCase.createProduct(createProductCommand);

    return new ProductCreatedModel(product.getProductNo());
  }
}
