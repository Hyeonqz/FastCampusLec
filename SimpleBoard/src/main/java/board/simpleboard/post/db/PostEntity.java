package board.simpleboard.post.db;

import board.simpleboard.reply.db.ReplyEntity;
import jakarta.persistence.*;
import lombok.*;

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

    private Long boardId; // -> 대문자로 끊으면 알아서 snake case 로 들어간다.
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
