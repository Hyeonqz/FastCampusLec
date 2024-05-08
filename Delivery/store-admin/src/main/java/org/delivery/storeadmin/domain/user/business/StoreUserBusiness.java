package org.delivery.storeadmin.domain.user.business;

import java.util.Optional;

import org.delivery.storeadmin.common.annotation.Business;
import org.delivery.storeadmin.domain.user.controller.model.StoreUserRegisterRequest;
import org.delivery.storeadmin.domain.user.controller.model.StoreUserResponse;
import org.delivery.storeadmin.domain.user.converter.StoreUserConverter;
import org.delivery.storeadmin.domain.user.service.StoreUserService;
import org.example.db.store.StoreEntity;
import org.example.db.store.StoreRepository;
import org.example.db.store.enums.StoreStatus;
import org.example.db.storeuser.StoreUserEntity;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Business
public class StoreUserBusiness {

	private final StoreUserConverter storeUserConverter;
	private final StoreUserService storeUserService;
	private final StoreRepository storeRepository;

	@Transactional
	public StoreUserResponse register(StoreUserRegisterRequest req) {
		Optional<StoreEntity> firstByNameAndStatusOrderByIdDesc = storeRepository.findFirstByNameAndStatusOrderByIdDesc(
			req.getStoreName(), StoreStatus.REGISTERED);

		StoreUserEntity entity = storeUserConverter.toEntity(req, firstByNameAndStatusOrderByIdDesc.get());

		StoreUserEntity register = storeUserService.register(entity);

		return storeUserConverter.toResponse(register, firstByNameAndStatusOrderByIdDesc.get());
	}
}
