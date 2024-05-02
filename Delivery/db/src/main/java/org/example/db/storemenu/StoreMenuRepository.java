package org.example.db.storemenu;

import java.util.List;
import java.util.Optional;

import org.example.db.storemenu.enums.StoreMenuStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreMenuRepository extends JpaRepository<StoreMenuEntity, Long> {

	// 유효한 메뉴 체크
	Optional<StoreMenuEntity> findFirstByIdAndStatusOrderByIdDesc(Long id, StoreMenuStatus status);

	// 특정 가게의 메뉴 가져오기
	List<StoreMenuEntity> findAllByStoreIdAndStatusOrderBySequenceDesc(Long storeId, StoreMenuStatus status);
}
