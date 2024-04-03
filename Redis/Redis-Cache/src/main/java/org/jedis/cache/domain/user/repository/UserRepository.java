package org.jedis.cache.domain.user.repository;

import org.jedis.cache.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
