package org.example.db.userorder;

import java.util.List;
import java.util.Optional;

import org.example.db.userorder.enums.UserOrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserOrderRepository extends JpaRepository<UserOrderEntity, Long> {
	// 특정 유저의 모든 주문
	List<UserOrderEntity> findAllByUserIdAndStatusOrderByIdDesc(Long userId, UserOrderStatus status);

	// select * from user_order where user_id = ? and status in(?,? ...) order by id desc;
	List<UserOrderEntity> findAllByUserIdAndStatusInOrderByIdDesc(Long userId, List<UserOrderStatus> status);

	// 특정 주문
	Optional<UserOrderEntity> findAllByIdAndStatusAndUserId(Long id, UserOrderStatus status, Long userId);
}
