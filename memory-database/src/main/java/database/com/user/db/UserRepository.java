package database.com.user.db;

import database.com.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    // 상속 받았기 때문에
    // UserRepository 메모리 공간이 생기고, 각 메모리마다 ID를 가지는데 Long 타입으로 가지고
    // 각각 저장되는 타입은 UserEntity라는 내용으로 저장이 된다.
    public List<UserEntity> findAllByScoreGreaterThanEqual(int score);
    // find = select, All = 모든 컬럼, where=Score, GreaterThanEqauls = score>= score
    // By 뒤로는 where 절이 온다는걸 명시함.
    // 쿼리 메소드는 카멜케이스를 기준으로 짜른다.
    // 파라미터가 들어오는 순서대로 짜르게 된다.

    // JPQL

    public List<UserEntity> findAllByScoreGreaterThanEqualAndScoreLessThanEqual(int min, int max);


    @Query(
            "select u from user u where u.score >= :min and u.score <= :max"
            // u 는 Entity 이름을 뜻한다. 별칭이다. 즉 * 을 뜻함
            // u.score 는 userEntity 의 score 변수를 뜻함
            // ?1 -> 첫번째 파라미터, ?2 -> 두번째 파라미터
    )
    public List<UserEntity> score(
            @Param(value="min") int min,
            @Param(value="max") int max);
            // JPQL 에서 @Param 을 하게되면은 ?1, ?2 를 -> :min, :max로 바꿀 수 있다. ->nameParameter

}
