package org.jedis.cache.domain.user.repository;

import org.jedis.cache.domain.user.entity.RedisHashUser;
import org.springframework.data.repository.CrudRepository;

public interface RedisHashUserRepository extends CrudRepository<RedisHashUser,Long> {
}
