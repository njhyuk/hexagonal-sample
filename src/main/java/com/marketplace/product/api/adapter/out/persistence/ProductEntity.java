package com.marketplace.product.api.adapter.out.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "GOODS")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {
  @Column(name = "GOODS_NO")
  @Id
  @GeneratedValue
  private Long productNo;

  @Column(name = "GOODS_NM")
  private String name;

  @Column(name = "GOODS_CONT")
  private String contents;

  @Column(name = "COM_ID")
  private String companyId;

  @Column(name = "REG_DM")
  private LocalDateTime createDateTime;

  @Column(name = "UPD_DM")
  private LocalDateTime updateDateTime;
}
