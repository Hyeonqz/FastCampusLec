package org.example.api.domain.storemenu.business;

import java.util.List;

import org.example.api.common.annotation.Business;
import org.example.api.domain.storemenu.controller.model.StoreMenuRegisterRequest;
import org.example.api.domain.storemenu.controller.model.StoreMenuResponse;
import org.example.api.domain.storemenu.converter.StoreMenuConverter;
import org.example.api.domain.storemenu.service.StoreMenuService;
import org.example.db.storemenu.StoreMenuEntity;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Business
public class StoreMenuBusiness {
	private final StoreMenuConverter storeMenuConverter;
	private final StoreMenuService storeMenuService;

	// 등록
	public StoreMenuResponse register(StoreMenuRegisterRequest storeMenuRegisterRequest) {
		StoreMenuEntity entity = storeMenuConverter.toEntity(storeMenuRegisterRequest);
		StoreMenuEntity register = storeMenuService.register(entity);
		StoreMenuResponse response = storeMenuConverter.toResponse(register);
		return response;
	}

	// 조회
	public List<StoreMenuResponse> search(Long storeId) {
		List<StoreMenuEntity> storeMenuWithThrow = storeMenuService.getStoreMenuByStoreId(storeId);
		return storeMenuWithThrow.stream()
			// .map(it -> return storeMenuConverter.toResponse(it);
			.map(storeMenuConverter::toResponse) // entity 를 받아서, response 로 변환을 해준다.
			.toList();
	}
}
