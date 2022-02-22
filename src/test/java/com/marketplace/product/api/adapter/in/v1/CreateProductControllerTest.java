package com.marketplace.product.api.adapter.in.v1;

import com.marketplace.product.api.application.port.in.CreateProductCommand;
import com.marketplace.product.api.domain.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.JsonFieldType.NUMBER;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CreateProductControllerTest extends AbstractRestDocControllerTest {
  @Test
  @DisplayName("상품을 생성 한다")
  public void docLikeAction() throws Exception {

    CreateProductCommand command = new CreateProductCommand(
        "릴렉스드 베이식 블레이저 [블랙]",
        "<img src=\"//image.musinsa.com/images/prd_img/2021032911161200000086392.jpg\">",
        "musinsa"
    );
    Product product = Product.builder()
        .productNo(1L)
        .name("릴렉스드 베이식 블레이저 [블랙]")
        .contents("<img src=\"//image.musinsa.com/images/prd_img/2021032911161200000086392.jpg\">")
        .companyId("musinsa")
        .createDateTime(LocalDateTime.now())
        .updateDateTime(LocalDateTime.now())
        .build();

    when(createProductService.createProduct(refEq(command)))
        .thenReturn(product);

    this.mockMvc.perform(
        post("/v1/products")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(command))
    ).andExpect(
        status().isOk()
    ).andDo(
        document("product/create-product",
            getDocumentRequest(),
            getDocumentResponse(),
            responseFields(
                fieldWithPath("productNo").type(NUMBER).description("상품 번호")
            )
        )
    );
  }
}
