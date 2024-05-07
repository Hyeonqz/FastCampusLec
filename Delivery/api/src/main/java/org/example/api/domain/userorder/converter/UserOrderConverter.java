package org.example.api.domain.userorder.converter;

import java.math.BigDecimal;
import java.util.List;

import org.example.api.common.annotation.Converter;
import org.example.api.domain.user.model.User;
import org.example.api.domain.userorder.controller.model.UserOrderResponse;
import org.example.db.storemenu.StoreMenuEntity;
import org.example.db.userorder.UserOrderEntity;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Converter
public class UserOrderConverter {

	public UserOrderEntity toEntity(User user, List<StoreMenuEntity> storeMenuEntity) {
		var totalAmount = storeMenuEntity.stream()
			.map(StoreMenuEntity::getAmount)
			.reduce(BigDecimal.ZERO, BigDecimal::add);

		return UserOrderEntity.builder()
			.userId(user.getId())
			.amount(totalAmount)
			.build();
	}

	public UserOrderResponse toResponse(UserOrderEntity userOrderEntity) {
		return UserOrderResponse.builder()
			.id(userOrderEntity.getId())
			.status(userOrderEntity.getStatus())
			.amount(userOrderEntity.getAmount())
			.orderedAt(userOrderEntity.getOrderedAt())
			.acceptedAt(userOrderEntity.getAcceptedAt())
			.cookingStartedAt(userOrderEntity.getCookingStartedAt())
			.deliveryStartedAt(userOrderEntity.getDeliveryStartedAt())
			.receivedAt(userOrderEntity.getReceivedAt())
			.build();
	}
}
