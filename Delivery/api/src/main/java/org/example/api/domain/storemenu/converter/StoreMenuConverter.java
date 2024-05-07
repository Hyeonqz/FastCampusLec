package org.example.api.domain.storemenu.converter;

import java.util.List;
import java.util.Optional;

import org.example.api.common.annotation.Converter;
import org.example.api.common.error.ErrorCode;
import org.example.api.common.exception.ApiException;
import org.example.api.domain.storemenu.controller.model.StoreMenuRegisterRequest;
import org.example.api.domain.storemenu.controller.model.StoreMenuResponse;
import org.example.db.storemenu.StoreMenuEntity;

import lombok.RequiredArgsConstructor;

@Converter
public class StoreMenuConverter {

	public StoreMenuEntity toEntity(StoreMenuRegisterRequest storeMenuRegisterRequest) {
		return Optional.ofNullable(storeMenuRegisterRequest)
			.map(it -> {
				return StoreMenuEntity.builder()
					.storeId(storeMenuRegisterRequest.getStoreId())
					.name(storeMenuRegisterRequest.getName())
					.amount(storeMenuRegisterRequest.getAmount())
					.thumbnailUrl(storeMenuRegisterRequest.getThumbnailUrl())
					.build();

			})
			.orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT, "StoreMenuRegisterRequest is Null"));
	}

	public StoreMenuResponse toResponse(StoreMenuEntity storeMenuEntity) {
		return Optional.ofNullable(storeMenuEntity)
			.map(it -> {
				return StoreMenuResponse.builder()
					.id(storeMenuEntity.getStoreId())
					.storeId(storeMenuEntity.getStoreId())
					.amount(storeMenuEntity.getAmount())
					.status(storeMenuEntity.getStatus())
					.name(storeMenuEntity.getName())
					.sequence(storeMenuEntity.getSequence())
					.likeCount(storeMenuEntity.getLikeCount())
					.thumbnailUrl(storeMenuEntity.getThumbnailUrl())
					.build();
			})
			.orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT, "StoreMenuEntity is Null"));
	}

	public List<StoreMenuResponse> toResponse(List<StoreMenuEntity> storeMenuEntities) {
		return storeMenuEntities.stream()
			.map(this::toResponse)// it -> toResponse(it)
			.toList();
	}
}
