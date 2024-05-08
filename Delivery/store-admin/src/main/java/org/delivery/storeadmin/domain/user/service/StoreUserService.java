package org.delivery.storeadmin.domain.user.service;

import java.util.Optional;

import org.example.db.storeuser.StoreUserEntity;
import org.example.db.storeuser.StoreUserRepository;
import org.example.db.storeuser.enums.StoreUserStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StoreUserService {
	private final StoreUserRepository storeUserRepository;
	private final PasswordEncoder passwordEncoder;

	public StoreUserEntity register(StoreUserEntity storeUserEntity) {
		storeUserEntity.preSetting();
		return storeUserRepository.save(storeUserEntity);
	}

	public Optional<StoreUserEntity> getRegisterUser(String email) {
		return storeUserRepository.findFirstByEmailAndStatusOrderByIdDesc(email, StoreUserStatus.REGISTERED);
	}


}
