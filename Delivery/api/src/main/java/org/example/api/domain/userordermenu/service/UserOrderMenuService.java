package org.example.api.domain.userordermenu.service;

import java.util.List;

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
}
