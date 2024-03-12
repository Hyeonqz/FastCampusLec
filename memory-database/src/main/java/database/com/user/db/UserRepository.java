package database.com.user.db;

import database.com.db.SimpleDataRepository;
import database.com.user.model.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository extends SimpleDataRepository<UserEntity,Long> {
    // 상속 받았기 때문에
    // UserRepository 메모리 공간이 생기고, 각 메모리마다 ID를 가지는데 Long 타입으로 가지고
    // 각각 저장되는 타입은 UserEntity라는 내용으로 저장이 된다.
}
