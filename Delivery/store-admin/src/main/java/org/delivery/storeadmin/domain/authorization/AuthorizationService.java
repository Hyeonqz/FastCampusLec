package org.delivery.storeadmin.domain.authorization;

import org.delivery.storeadmin.domain.authorization.model.UserSession;
import org.delivery.storeadmin.domain.user.service.StoreUserService;
import org.example.db.store.StoreRepository;
import org.example.db.store.enums.StoreStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthorizationService implements UserDetailsService {

	private final StoreUserService storeUserService;
	private final StoreRepository storeRepository;

	@Override
	public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {

		var storeUserEntity = storeUserService.getRegisterUser(username);

		var storeEntity = storeRepository.findFirstByIdAndStatusOrderByIdDesc(
				storeUserEntity.get().getStoreId(), StoreStatus.REGISTERED);

		return storeUserEntity.map(it -> {
				// userDetail 수정한 객체 가져오기

				return UserSession.builder()
					.userId(it.getId())
					.password(it.getPassword())
					.email(it.getEmail())
					.status(it.getStatus())
					.role(it.getRole())
					.registeredAt(it.getRegisteredAt())
					.lastLoginAt(it.getLastLoginAt())
					.unregisteredAt(it.getUnregisteredAt())

					.storeId(storeEntity.get().getId())
					.storeName(storeEntity.get().getName())
					.build();
			})
			.orElseThrow(() -> new UsernameNotFoundException(username));
	}

}