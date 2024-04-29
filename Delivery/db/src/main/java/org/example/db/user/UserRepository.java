package org.example.db.user;

import java.util.Optional;

import org.example.db.user.enums.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	// select * from user where id= ? and status = ? order by id desc limit1;
	Optional<UserEntity> findFirstByIdAndStatusOrderByIdDesc(Long id, UserStatus status); // 1개만 찾는 로직

	// select * from user where email = ? and password = ? and status = ? order by id desc;
	Optional<UserEntity> findFirstByEmailAndPasswordAndStatusOrderByIdDesc(String email, String password, UserStatus status);
}
