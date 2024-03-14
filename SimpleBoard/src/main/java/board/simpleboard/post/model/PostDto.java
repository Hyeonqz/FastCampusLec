package board.simpleboard.post.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDto {

    // DB로 들어갈 때는 소문자로 들어감
    private Long id;

    private Long boardId; // -> 대문자로 끊으면 알아서 snake case 로 들어간다.
    // 위 변수를 적용하면, 위 변수 자체를 column 으로 인식하고 자동으로 _id 를 붙인다. 죽 board_id 를 찾는다.

    private String userName;
    private String password;
    private String email;
    private String status;
    private String title;

    private String content;
    private LocalDateTime postedAt;

}
