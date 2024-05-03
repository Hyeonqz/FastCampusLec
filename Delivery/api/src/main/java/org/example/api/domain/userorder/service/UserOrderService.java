package org.example.api.domain.userorder.service;

import java.util.List;
import java.util.Optional;

import org.example.api.common.error.ErrorCode;
import org.example.api.common.exception.ApiException;
import org.example.db.userorder.UserOrderEntity;
import org.example.db.userorder.UserOrderRepository;
import org.example.db.userorder.enums.UserOrderStatus;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserOrderService {
	private final UserOrderRepository userOrderRepository;

	// 주문 내역 가져오기
	public UserOrderEntity getUserOrderWithThrow(Long id, Long userId) {
		return userOrderRepository.findAllByIdAndStatusAndUserId(id, UserOrderStatus.REGISTERED, userId)
			.orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
	}

	// 특정 사용자 주문내역 조회
	public List<UserOrderEntity> getUserOrderList(Long userId) {
		return userOrderRepository.findAllByUserIdAndStatusOrderByIdDesc(userId, UserOrderStatus.REGISTERED);
	}

	public List<UserOrderEntity> getUserOrderList(Long userId, List<UserOrderStatus> statusList) {
		return userOrderRepository.findAllByUserIdAndStatusInOrderByIdDesc(userId, statusList);
	}

	// 음식 주문 -> 새로운 내역을 쌓는것 (create)
	public UserOrderEntity order(UserOrderEntity userOrderEntity) {
		return Optional.ofNullable(userOrderEntity)
			.map(it -> {
				it.order();
				return userOrderRepository.save(it);
			})
			.orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
	}


	// 주문 상태 변경
	public UserOrderEntity chaneStatus(UserOrderEntity userOrderEntity, UserOrderStatus status) {
		userOrderEntity.changeStatus(status);
		return userOrderRepository.save(userOrderEntity);
	}


	// 주문 확인 ->
	public UserOrderEntity accept(UserOrderEntity userOrderEntity) {
		userOrderEntity.changeAccept();
		return chaneStatus(userOrderEntity, UserOrderStatus.ACCEPT);
	}

	// 조리 시작
	public UserOrderEntity cooking(UserOrderEntity userOrderEntity) {
		userOrderEntity.changeCooking();
		return chaneStatus(userOrderEntity, UserOrderStatus.COOKING);
	}


	// 배달 시작
	public UserOrderEntity delivery(UserOrderEntity userOrderEntity) {
		userOrderEntity.changeDelivery();
		return chaneStatus(userOrderEntity, UserOrderStatus.DELIVERING);
	}

	// 배달 완료
	public UserOrderEntity received(UserOrderEntity userOrderEntity) {
		userOrderEntity.changeReceived();
		return chaneStatus(userOrderEntity, UserOrderStatus.RECEIVE);
	}

	// 현재 진행중인 주문 내역
	public List<UserOrderEntity> currentOrder(Long userId) {
		return getUserOrderList(userId, List.of(
			UserOrderStatus.ORDER,
			UserOrderStatus.COOKING,
			UserOrderStatus.DELIVERING,
			UserOrderStatus.ACCEPT
		));
	}

	// 과거 주문한 내역
	public List<UserOrderEntity> historyOrder(Long userId) {
		return getUserOrderList(userId, List.of(
			UserOrderStatus.ORDER,
			UserOrderStatus.RECEIVE
		));
	}

}
