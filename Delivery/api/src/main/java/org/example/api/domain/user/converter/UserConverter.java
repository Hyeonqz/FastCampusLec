package org.example.api.domain.user.converter;

import java.util.Optional;

import org.example.api.common.annotation.Converter;
import org.example.api.common.error.ErrorCode;
import org.example.api.domain.user.controller.model.req.UserRegisterRequest;
import org.example.api.domain.user.controller.model.res.UserResponse;
import org.example.api.exceptionhandler.exception.ApiException;
import org.example.db.user.UserEntity;
import org.example.db.user.enums.UserStatus;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Converter
public class UserConverter {

	// DTO -> Entity
	// 파라미터인 리퀘스트를 받아와서 엔티티로 만들어서 리턴한다.
	public UserEntity toEntity(UserRegisterRequest userRegisterRequest) {
		// request 가 null 일수도있으니 null 체크를 하는 로직도 추가한다.
		return Optional.ofNullable(userRegisterRequest)
			.map(it -> {
				// DTO -> Entity
				return UserEntity.builder()
					.name(userRegisterRequest.getName())
					.email(userRegisterRequest.getEmail())
					.password(userRegisterRequest.getPassword())
					.address(userRegisterRequest.getAddress())
					.build();
			})
			.orElseThrow( () -> new ApiException(ErrorCode.NULL_POINT, "UserRegisterRequest Null"));
	}


	// Entity -> Dto
	// 파라미터인 엔티티를 받아와서 DTO로 만들어서 리턴한다.
	public UserResponse toResponse (UserEntity userEntity) {
		return Optional.ofNullable(userEntity)
			.map(it -> {
				// Entity -> Response
				return UserResponse.builder()
					.id(userEntity.getId())
					.name(userEntity.getName())
					.address(userEntity.getAddress())
					.status(UserStatus.UNREGISTERED)
					.email(userEntity.getEmail())
					.registeredAt(userEntity.getRegisteredAt())
					.unregisteredAt(userEntity.getUnregisteredAt())
					.lastLoginAt(userEntity.getLastLoginAt())
					.build();
			})
			.orElseThrow( () -> new ApiException(ErrorCode.NULL_POINT, "UserEntity Null"));
	}

}
