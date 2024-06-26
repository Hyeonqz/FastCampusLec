package org.example.api.domain.userordermenu.service;

import java.util.List;
import java.util.Optional;

import org.example.api.common.error.ErrorCode;
import org.example.api.common.exception.ApiException;
import org.example.db.userordermenu.UserOrderMenuEntity;
import org.example.db.userordermenu.UserOrderMenuRepository;
import org.example.db.userordermenu.enums.UserOrderMenuStatus;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserOrderMenuService {
	private final UserOrderMenuRepository userOrderMenuRepository;

	public List<UserOrderMenuEntity> getUserOrderMenu(Long userOrderId) {
		return userOrderMenuRepository.findAllByUserOrderIdAndStatus(userOrderId, UserOrderMenuStatus.REGISTERED);
	}

	public UserOrderMenuEntity order(UserOrderMenuEntity userOrderMenuEntity) {
		return Optional.ofNullable(userOrderMenuEntity)
			.map(it -> {
				it.setMenu();
				return userOrderMenuRepository.save(it);
			})
			.orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
	}
}
