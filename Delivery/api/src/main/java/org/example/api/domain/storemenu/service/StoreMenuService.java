package org.example.api.domain.storemenu.service;

import java.util.List;
import java.util.Optional;

import org.example.api.common.error.ErrorCode;
import org.example.api.common.exception.ApiException;
import org.example.db.storemenu.StoreMenuEntity;
import org.example.db.storemenu.StoreMenuRepository;
import org.example.db.storemenu.enums.StoreMenuStatus;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StoreMenuService {
	private final StoreMenuRepository storeMenuRepository;

	// 메뉴 등록
	public StoreMenuEntity register(StoreMenuEntity storeMenuEntity) {
		return Optional.ofNullable(storeMenuEntity)
			.map(it -> {
				it.setRegister();
				return storeMenuRepository.save(it);
			})
			.orElseThrow( () -> new ApiException(ErrorCode.NULL_POINT, "StoreMenuEntity is Null"));
	}

	// 메뉴 조회
	public StoreMenuEntity getStoreMenuWithThrow(Long id) {
		Optional<StoreMenuEntity> entity = storeMenuRepository.findFirstByIdAndStatusOrderByIdDesc(id, StoreMenuStatus.REGISTERED);
		return entity.orElseThrow( () -> new ApiException(ErrorCode.NULL_POINT, "StoreMenuEntity is Null"));
	}

	// 연관 관계 설정 전이므로 이렇게 해봄
	public List<StoreMenuEntity> getStoreMenuByStoreId(Long storeId) {
		return storeMenuRepository.findAllByStoreIdAndStatusOrderBySequenceDesc(storeId, StoreMenuStatus.REGISTERED);
	}
}
