package board.simpleboard.reply.db;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
@Entity(name="reply")
@Builder
public class ReplyEntity {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long postId;
    private String userName;
    private String password;
    private String email;
    private String status;
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;
    private LocalDateTime repliedAt;
}


