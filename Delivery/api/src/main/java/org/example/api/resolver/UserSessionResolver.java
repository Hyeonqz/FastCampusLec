package org.example.api.resolver;

import org.example.api.common.annotation.UserSession;
import org.example.api.domain.user.model.User;
import org.example.api.domain.user.service.UserService;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserSessionResolver implements HandlerMethodArgumentResolver {
	private final UserService userService;

	// AOP 방식으로 동작시키기 위함이다.

	@Override
	public boolean supportsParameter (MethodParameter parameter) {
		// 지원하는 파라미터 체크, 어노테이션 체크

		// 1. 어노테이션이 존재 하는지 체크
		Boolean isExist = parameter.hasParameterAnnotation(UserSession.class);
		// 2. 파라미터 타입 체크가 동일한지 체크
		Boolean parameterType = parameter.getParameterType().equals(User.class);

		// true 일 때만 실행
		return (isExist && parameterType);

	}

	@Override
	public Object resolveArgument (MethodParameter parameter, ModelAndViewContainer mavContainer,
		NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		// support 파라미터를 통과하면(true 반환시) -> 위 로직 실행

		// request context holder 에서 찾아온다
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();

		assert requestAttributes != null;
		var userId = requestAttributes.getAttribute("userId", RequestAttributes.SCOPE_REQUEST);

		assert userId != null;
		var userEntity = userService.getUserWithThrow(Long.parseLong(userId.toString()));

		// 사용자 장보 셋팅
		return User.builder()
			.id(userEntity.getId())
			.name(userEntity.getName())
			.email(userEntity.getEmail())
			.password(userEntity.getPassword())
			.status(userEntity.getStatus())
			.address(userEntity.getAddress())
			.registeredAt(userEntity.getRegisteredAt())
			.unregisteredAt(userEntity.getUnregisteredAt())
			.lastLoginAt(userEntity.getLastLoginAt())
			.build();

	}

}
