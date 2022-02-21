package com.marketplace.product.api.adapter.out.persistence;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@Builder
@Table("GOODS")
public class ProductEntity {
  @Id
  @Column("GOODS_NO")
  private Long productNo;
  @Column("GOODS_NM")
  private String name;
  @Column("GOODS_CONT")
  private String contents;
  @Column("COM_ID")
  private String companyId;
  @Column("REG_DM")
  private LocalDateTime createDateTime;
  @Column("UPD_DM")
  private LocalDateTime updateDateTime;
}
