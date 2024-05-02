package org.example.api.domain.store.converter;

import java.util.Optional;

import org.example.api.common.annotation.Converter;
import org.example.api.common.error.ErrorCode;
import org.example.api.common.exception.ApiException;
import org.example.api.domain.store.controller.model.StoreRegisterRequest;
import org.example.api.domain.store.controller.model.StoreResponse;
import org.example.api.domain.store.service.StoreService;
import org.example.db.store.StoreEntity;
import org.example.db.store.enums.StoreCategory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Converter
public class StoreConverter {
	private final StoreService service;

	// Entity 로 바꾸는건 항상 Request 이다.
	public StoreEntity toEntity(StoreRegisterRequest storeRegisterRequest) {
		return Optional.ofNullable(storeRegisterRequest)
			.map(it -> {
				return StoreEntity.builder()
					.name(storeRegisterRequest.getName())
					.address(storeRegisterRequest.getAddress())
					.category(storeRegisterRequest.getStoreCategory())
					.minimumAmount(storeRegisterRequest.getMinimumAmount())
					.minimumDeliveryAmount(storeRegisterRequest.getMinimumDeliveryAmount())
					.thumbnailUrl(storeRegisterRequest.getThumbnailUrl())
					.phoneNumber(storeRegisterRequest.getPhoneNumber())
					.build();
			})
			.orElseThrow( () -> new ApiException(ErrorCode.NULL_POINT, "Entity Null"));
	}

	// 응답을 받는건 항상 Response 이다. Entity -> response
	public StoreResponse toResponse(StoreEntity storeEntity) {
		return Optional.ofNullable(storeEntity)
			.map(it -> {
				return StoreResponse.builder()
					.id(storeEntity.getId())
					.name(storeEntity.getName())
					.address(storeEntity.getAddress())
					.category(storeEntity.getCategory())
					.status(storeEntity.getStatus())
					.star(storeEntity.getStar())
					.minimumAmount(storeEntity.getMinimumAmount())
					.minimumDeliveryAmount(storeEntity.getMinimumDeliveryAmount())
					.thumbnailUrl(storeEntity.getThumbnailUrl())
					.phoneNumber(storeEntity.getPhoneNumber())
					.build();
			})
			.orElseThrow( () -> new ApiException(ErrorCode.NULL_POINT, "Entity Null"));

	}
}
