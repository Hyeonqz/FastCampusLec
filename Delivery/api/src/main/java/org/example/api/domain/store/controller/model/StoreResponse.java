package org.example.api.domain.store.controller.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.example.db.store.enums.StoreCategory;
import org.example.db.store.enums.StoreStatus;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StoreResponse {

	private Long id;

	private String name;

	private String address;

	private StoreStatus status;

	private StoreCategory category;

	private double star;

	private String thumbnailUrl;

	private BigDecimal minimumAmount;

	private BigDecimal minimumDeliveryAmount;

	private String phoneNumber;

	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
