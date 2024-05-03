package org.example.db.userorder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.example.db.BaseEntity;
import org.example.db.userorder.enums.UserOrderStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Entity(name="user_order")
public class UserOrderEntity extends BaseEntity {

	@Column(nullable = false)
	private Long userId; // user table 1:n 관계

	@Column(columnDefinition = "varchar(50)", nullable = false)
	@Enumerated(EnumType.STRING)
	private UserOrderStatus status;

	@Column(precision = 11, scale = 4, nullable = false)
	private BigDecimal amount;

	private LocalDateTime orderedAt;

	private LocalDateTime acceptedAt;

	private LocalDateTime cookingStartedAt;

	private LocalDateTime deliveryStartedAt;

	private LocalDateTime receivedAt;

	public void order () {
		this.status = UserOrderStatus.ORDER;
		this.orderedAt = LocalDateTime.now();
	}

	// 주문 상태 변경
	public void changeStatus(UserOrderStatus status) {
		this.status = status;
	}

	// 주문 확인 상태 변경
	public void changeAccept() {
		this.acceptedAt = LocalDateTime.now();
	}

	public void changeCooking() {
		this.cookingStartedAt = LocalDateTime.now();
	}

	public void changeDelivery() {
		this.deliveryStartedAt = LocalDateTime.now();
	}

	public void changeReceived() {
		this.receivedAt = LocalDateTime.now();
	}
}
