package com.marketplace.product.api.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Getter;
import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class CreateProductCommand {
  @NotBlank(message = "제목 필드는 필수입니다.")
  private final String name;
  @NotBlank(message = "내용 필드는 필수입니다.")
  private final String contents;
  @NotBlank(message = " 업체 아이디 필드는 필수입니다.")
  private final String companyId;
}
