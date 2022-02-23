package com.marketplace.product.api.adapter.in.web.v1;

import com.marketplace.product.api.domain.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.JsonFieldType.NUMBER;
import static org.springframework.restdocs.payload.JsonFieldType.STRING;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class GetProductControllerTest extends AbstractRestDocControllerTest {
  @Test
  @DisplayName("상품 상세 데이터를 가져 온다")
  public void docGetProduct() throws Exception {
    Product product = Product.builder()
        .productNo(1L)
        .name("릴렉스드 베이식 블레이저 [블랙]")
        .contents("<img src=\"//image.musinsa.com/images/prd_img/2021032911161200000086392.jpg\">")
        .companyId("musinsa")
        .createDateTime(LocalDateTime.now())
        .updateDateTime(LocalDateTime.now())
        .build();

    when(getProductService.getProduct(1L))
        .thenReturn(product);

    this.mockMvc.perform(
        get("/v1/products/{productNo}", 1L)
    ).andExpect(
        status().isOk()
    ).andDo(
        document("product/get-product",
            getDocumentRequest(),
            getDocumentResponse(),
            pathParameters(
                parameterWithName("productNo").description("상품 번호")
            ),
            responseFields(
                fieldWithPath("productNo").type(NUMBER).description("상품번호"),
                fieldWithPath("name").type(STRING).description("상품명"),
                fieldWithPath("contents").type(STRING).description("상품설명"),
                fieldWithPath("companyId").type(STRING).description("업체 아이디"),
                fieldWithPath("createDateTime").type(STRING).description("상품정보 최초등록일시"),
                fieldWithPath("updateDateTime").type(STRING).description("상품정보 수정일시")
            )
        )
    );
  }
}
