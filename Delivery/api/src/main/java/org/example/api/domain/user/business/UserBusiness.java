package org.example.api.domain.user.business;

import java.util.Optional;

import org.example.api.common.annotation.Business;
import org.example.api.common.error.ErrorCode;
import org.example.api.domain.user.controller.model.req.UserLoginRequest;
import org.example.api.domain.user.controller.model.req.UserRegisterRequest;
import org.example.api.domain.user.controller.model.res.UserResponse;
import org.example.api.domain.user.converter.UserConverter;
import org.example.api.domain.user.service.UserService;
import org.example.api.exceptionhandler.exception.ApiException;
import org.example.db.user.UserEntity;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Business
public class UserBusiness {
	private final UserService userService;
	private final UserConverter userConverter;

	// 사용자에 대한 가입 처리 로직이 들어가야함
	// 리퀘스트를 엔티티로 바꿔준다음에 리턴을 시킨다
	/*
	* 1. request -> entity
	* 2. entity -> save
	* 3. save Entity -> response
	* 4. response return
	* */
	@Transactional
	public UserResponse register (UserRegisterRequest request) {
/*		UserEntity entity = userConverter.toEntity(request);
		UserEntity register = userService.register(entity);
		return userConverter.toResponse(register);*/

		// 함수형 코딩
		return Optional.ofNullable(request)
			.map(userConverter::toEntity) //Entity 로 변환
			.map(userService::register) // register 로 변환
			.map(userConverter::toResponse) // toResponse 로 변환
			.orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT, "Request Null"));
	}


}
