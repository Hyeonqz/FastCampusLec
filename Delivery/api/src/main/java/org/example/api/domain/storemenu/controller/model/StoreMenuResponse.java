package org.example.api.domain.storemenu.controller.model;

import java.math.BigDecimal;

import org.example.db.storemenu.enums.StoreMenuStatus;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StoreMenuResponse {

	private Long id;
	private Long storeId;
	private String name;
	private BigDecimal amount;
	private StoreMenuStatus status;
	private String thumbnailUrl;
	private Integer likeCount;
	private Integer sequence;

}
