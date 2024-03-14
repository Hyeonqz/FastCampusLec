package board.simpleboard.bboard.db;

import board.simpleboard.post.db.PostEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name="board")
public class BoardEntity {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String boardName;

    private String status;

    @OneToMany(mappedBy = "board")
    // 뭐랑 엮을건지를 의미한다. boardEntity 는 PostEntity 의 boardEntity 변수 를 의미한다. 즉 1:N 의 뜻함
    private List<PostEntity> postList = List.of();
}
