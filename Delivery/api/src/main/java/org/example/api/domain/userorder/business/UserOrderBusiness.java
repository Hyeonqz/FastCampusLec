package org.example.api.domain.userorder.business;

import java.util.List;
import java.util.stream.Collectors;

import org.example.api.common.annotation.Business;
import org.example.api.domain.store.converter.StoreConverter;
import org.example.api.domain.store.service.StoreService;
import org.example.api.domain.storemenu.converter.StoreMenuConverter;
import org.example.api.domain.storemenu.service.StoreMenuService;
import org.example.api.domain.user.model.User;
import org.example.api.domain.userorder.controller.model.UserOrderDetailResponse;
import org.example.api.domain.userorder.controller.model.UserOrderRequest;
import org.example.api.domain.userorder.controller.model.UserOrderResponse;
import org.example.api.domain.userorder.converter.UserOrderConverter;
import org.example.api.domain.userorder.producer.UserOrderProducer;
import org.example.api.domain.userorder.service.UserOrderService;
import org.example.api.domain.userordermenu.converter.UserOrderMenuConverter;
import org.example.api.domain.userordermenu.service.UserOrderMenuService;
import org.example.db.store.StoreEntity;
import org.example.db.userorder.UserOrderEntity;
import org.example.db.userordermenu.UserOrderMenuEntity;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Business
public class UserOrderBusiness {
	private final UserOrderConverter userOrderConverter;
	private final UserOrderMenuConverter userOrderMenuConverter;
	private final UserOrderService userOrderService;
	private final StoreMenuService storeMenuService;
	private final StoreMenuConverter storeMenuConverter;
	private final UserOrderMenuService userOrderMenuService;
	private final StoreService storeService;
	private final StoreConverter storeConverter;
	private final UserOrderProducer userOrderProducer;

	// 사용자, 메뉴 id
	// userOrder 생성
	// userOrderMenu 생성
	// 응답 생성한다.
	@Transactional
	public UserOrderResponse userOrder (User user, UserOrderRequest body) {
		var storeMenuList = body.getStoreMenuIdList()
			.stream()
			.map(storeMenuService::getStoreMenuWithThrow)
			.toList();
		UserOrderEntity userOrderEntity = userOrderConverter.toEntity(user, storeMenuList);
		// 주문
		var newUserOrderEntity = userOrderService.order(userOrderEntity);

		// 맵핑
		var userOrderMenuEntityList = storeMenuList.stream()
			.map(it -> {
				// menu + userOrder
				UserOrderMenuEntity entity = userOrderMenuConverter.toEntity(newUserOrderEntity, it);
				return entity;
			})
			.toList();

		// 주문 내역 기록 남기기
		userOrderMenuEntityList.forEach(userOrderMenuService::order);

		// 비동기로 가맹점 주문 알리기
		userOrderProducer.sendOrder(newUserOrderEntity);

		// response
		return userOrderConverter.toResponse(newUserOrderEntity);
	}

	public List<UserOrderDetailResponse> current (User user) {
		var userOrderEntityList = userOrderService.currentOrder(user.getId());

		// 주문 1건씩 처리
		var userOrderDetailResponseList = userOrderEntityList.stream()
			.map(it -> {
				var storeEntity = new StoreEntity();

				// 사용자가 주문 메뉴
				var userOrderMenuEntityList = userOrderMenuService.getUserOrderMenu(user.getId());
				var storeMenuEntityList = userOrderMenuEntityList.stream()
					.map(userOrderMenuEntity -> {
						var storeMenuEntity = storeMenuService.getStoreMenuWithThrow(userOrderMenuEntity.getStoreMenuId());
						return storeMenuEntity;
					})
					.toList();

				// 사용자가 주문한 스토어 TODO 리팩토링 필요(null 터질 수 있음)
				var storeEntityList = storeService.getStoreWithThrow(storeMenuEntityList.stream().findFirst().get().getStoreId());

				return UserOrderDetailResponse.builder()
					.userOrderResponse(userOrderConverter.toResponse(it))
					.storeResponse(storeConverter.toResponse(storeEntityList))
					.storeMenuResponseList(storeMenuConverter.toResponse(storeMenuEntityList))
					.build();
			}).collect(Collectors.toList());
		return userOrderDetailResponseList;
	}

	public List<UserOrderDetailResponse> history (User user) {
		var userOrderEntityList = userOrderService.historyOrder(user.getId());

		// 주문 1건씩 처리
		var userOrderDetailResponseList = userOrderEntityList.stream()
			.map(it -> {
				var storeEntity = new StoreEntity();

				// 사용자가 주문 메뉴
				var userOrderMenuEntityList = userOrderMenuService.getUserOrderMenu(user.getId());
				var storeMenuEntityList = userOrderMenuEntityList.stream()
					.map(userOrderMenuEntity -> {
						var storeMenuEntity = storeMenuService.getStoreMenuWithThrow(userOrderMenuEntity.getStoreMenuId());
						return storeMenuEntity;
					})
					.toList();

				// 사용자가 주문한 스토어 TODO 리팩토링 필요(null 터질 수 있음)
				var storeEntityList = storeService.getStoreWithThrow(storeMenuEntityList.stream().findFirst().get().getStoreId());

				return UserOrderDetailResponse.builder()
					.userOrderResponse(userOrderConverter.toResponse(it))
					.storeResponse(storeConverter.toResponse(storeEntityList))
					.storeMenuResponseList(storeMenuConverter.toResponse(storeMenuEntityList))
					.build();
			}).collect(Collectors.toList());
		return userOrderDetailResponseList;
	}

	public UserOrderDetailResponse read (User user, Long orderId) {
		var userOrderEntity = userOrderService.getUserOrderWithOutStatusWithThrow(orderId, user.getId());

		// 사용자가 주문한 메뉴
		var userOrderMenuEntityList = userOrderMenuService.getUserOrderMenu(userOrderEntity.getId());
		var storeMenuEntityList = userOrderMenuEntityList.stream()
			.map(userOrderMenuEntity -> {
				var storeMenuEntity = storeMenuService.getStoreMenuWithThrow(userOrderMenuEntity.getStoreMenuId());
				return storeMenuEntity;
			})
			.toList();

		// 사용자가 주문한 스토어 TODO 리팩토링
		var storeEntityList = storeService.getStoreWithThrow(storeMenuEntityList.stream().findFirst().get().getStoreId());

		return UserOrderDetailResponse.builder()
			.userOrderResponse(userOrderConverter.toResponse(userOrderEntity))
			.storeResponse(storeConverter.toResponse(storeEntityList))
			.storeMenuResponseList(storeMenuConverter.toResponse(storeMenuEntityList))
			.build();
	}


}
