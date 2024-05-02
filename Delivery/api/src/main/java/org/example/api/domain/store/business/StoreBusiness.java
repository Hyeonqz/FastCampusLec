package org.example.api.domain.store.business;

import java.util.List;
import java.util.stream.Collectors;

import org.example.api.common.annotation.Business;
import org.example.api.domain.store.controller.model.StoreRegisterRequest;
import org.example.api.domain.store.controller.model.StoreResponse;
import org.example.api.domain.store.converter.StoreConverter;
import org.example.api.domain.store.service.StoreService;
import org.example.db.store.StoreEntity;
import org.example.db.store.enums.StoreCategory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Business
public class StoreBusiness {
	private final StoreService storeService;
	private final StoreConverter storeConverter;

	// 가게 등록
	public StoreResponse register(StoreRegisterRequest storeRegisterRequest) {
		// req -> entity -> response
		StoreEntity entity = storeConverter.toEntity(storeRegisterRequest); // request -> entity
		StoreEntity register = storeService.register(entity); // entity -> 등록
		StoreResponse response = storeConverter.toResponse(register); // 등록된 entity -> response
		return response;
	}

	// 카테고리별 가게 조회
	public List<StoreResponse> searchCategory(StoreCategory storeCategory) {
		List<StoreEntity> storeList = storeService.searchByCategory(storeCategory);
		return storeList.stream()
			.map(storeConverter::toResponse)
			.toList();
	}

}
