package board.simpleboard.post.db;

import board.simpleboard.bboard.db.BoardEntity;
import board.simpleboard.reply.db.ReplyEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Getter @Setter @ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name="post")
public class PostEntity {

    // DB로 들어갈 때는 소문자로 들어감
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne // 나는 N 이고 상대방은 1이다.
    @JsonIgnore
    @ToString.Exclude
    private BoardEntity board; // -> 대문자로 끊으면 알아서 snake case 로 들어간다.
    // 위 변수를 적용하면, 위 변수 자체를 column 으로 인식하고 자동으로 _id 를 붙인다. 죽 board_id 를 찾는다.

    private String userName;
    private String password;
    private String email;
    private String status;
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;
    private LocalDateTime postedAt;

    @Transient //이것은 column 으로 쓰지 않겠다는 뜻
    private List<ReplyEntity> replyList = List.of();

}
