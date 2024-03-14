package board.simpleboard.bboard.db;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

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
}
