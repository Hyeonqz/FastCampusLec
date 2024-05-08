package org.delivery.storeadmin.domain.user.converter;

import java.util.Optional;

import org.delivery.storeadmin.common.annotation.Converter;
import org.delivery.storeadmin.domain.user.controller.model.StoreUserRegisterRequest;
import org.delivery.storeadmin.domain.user.controller.model.StoreUserResponse;
import org.example.db.store.StoreEntity;
import org.example.db.store.StoreRepository;
import org.example.db.store.enums.StoreStatus;
import org.example.db.storeuser.StoreUserEntity;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Converter
public class StoreUserConverter {
	// TODO Service 생기면 이관
	private final StoreRepository storeRepository;

	public StoreUserEntity toEntity (StoreUserRegisterRequest request, StoreEntity storeEntity) {
		return StoreUserEntity.builder()
			.email(request.getEmail())
			.password(request.getPassword())
			.role(request.getRole())
			.storeId(storeEntity.getId())
			.build();
	}

	public StoreUserResponse toResponse (StoreUserEntity storeUserEntity, StoreEntity storeEntity) {
		return StoreUserResponse.builder()
			.user(StoreUserResponse
				.UserReponse.builder()
				.id(storeUserEntity.getId())
				.email(storeUserEntity.getEmail())
				.status(storeUserEntity.getStatus())
				.role(storeUserEntity.getRole())
				.registeredAt(storeUserEntity.getRegisteredAt())
				.unregisteredAt(storeUserEntity.getUnregisteredAt())
				.lastLoginAt(storeUserEntity.getLastLoginAt())
				.build())
			.store(StoreUserResponse
				.StoreResponse.builder()
				.id(storeEntity.getId())
				.name(storeEntity.getName())
				.build())
			.build();
	}

}
