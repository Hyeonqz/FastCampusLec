package board.simpleboard.post.repository;

import board.simpleboard.post.db.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<PostEntity,Long> {

    public Optional<PostEntity> findFirstByIdAndStatusOrderByIdDesc(Long id, String status);
}
