package org.example.api.domain.store.service;

import java.util.List;
import java.util.Optional;

import org.example.api.common.api.Api;
import org.example.api.common.error.ErrorCode;
import org.example.api.common.exception.ApiException;
import org.example.db.store.StoreEntity;
import org.example.db.store.StoreRepository;
import org.example.db.store.enums.StoreCategory;
import org.example.db.store.enums.StoreStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class StoreService {
	private final StoreRepository storeRepository;

	// 유효한 스토어 가져오기
	public StoreEntity getStoreWithThrow (Long id) {
		Optional<StoreEntity> entity = storeRepository.findFirstByIdAndStatusOrderByIdDesc(id, StoreStatus.REGISTERED);
		return entity.orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
	}

	// 스토어 등록
	@Transactional
	public StoreEntity register (StoreEntity storeEntity) {
		return Optional.ofNullable(storeEntity)
			.map(it -> {

				it.register();

				return storeRepository.save(it);
			})
			.orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
	}

	// 카테고리로 스토어 조회
	public List<StoreEntity> searchByCategory (StoreCategory storeCategory) {
		List<StoreEntity> list = storeRepository.findAllByStatusAndCategoryOrderByStarDesc(
			StoreStatus.REGISTERED, storeCategory);

		return list;
	}

	// 전체 스토어 조회
	public List<StoreEntity> searchAll() {
		List<StoreEntity> all = storeRepository.findAllByStatusOrderByIdDesc(
			StoreStatus.REGISTERED);
		return all;
	}
}
