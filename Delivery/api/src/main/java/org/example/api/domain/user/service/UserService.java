package org.example.api.domain.user.service;

import java.util.Optional;

import org.example.api.common.error.ErrorCode;
import org.example.api.exceptionhandler.exception.ApiException;
import org.example.db.user.UserEntity;
import org.example.db.user.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	private final UserRepository userRepository;
	// User 도메인 로직만 처리를 할 것이다

	// 외부에서 사용하라면 엔티티만 받아오게
	@Transactional
	public UserEntity register(UserEntity userEntity) {
		return Optional.ofNullable(userEntity)
			.map(it -> {
				// 넘어온 userEntity 에가입시키기 위해서 데이텅 세팅하는 것.
				// userEntity.setStatus(UserStatus.REGISTERED);
				// userEntity.setRegisteredAt(LocalDateTime.now());
				it.register();

				return userRepository.save(userEntity);
			})
			.orElseThrow( () -> new ApiException(ErrorCode.NULL_POINT, "UserEntity Null"));
	}
}
