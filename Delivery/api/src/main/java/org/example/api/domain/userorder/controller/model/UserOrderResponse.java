package org.example.api.domain.userorder.controller.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.example.db.userorder.enums.UserOrderStatus;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class UserOrderResponse {

	private Long id;
	private UserOrderStatus status;
	private LocalDateTime orderedAt;
	private BigDecimal amount;
	private LocalDateTime acceptedAt;
	private LocalDateTime cookingStartedAt;
	private LocalDateTime deliveryStartedAt;
	private LocalDateTime receivedAt;

}
