package board.simpleboard.post.service;

import board.simpleboard.post.db.PostEntity;
import board.simpleboard.post.model.PostRequestDTO;
import board.simpleboard.post.model.PostViewRequest;
import board.simpleboard.post.repository.PostRepository;
import board.simpleboard.reply.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;
    private final ReplyService replyService;

    public PostEntity create(PostRequestDTO postRequestDTO) {
        var entity = PostEntity.builder()
                .boardId(1L)
                .userName(postRequestDTO.getUserName())
                .password(postRequestDTO.getPassword())
                .email(postRequestDTO.getEmail())
                .status("REGISTERED")
                .title(postRequestDTO.getTitle())
                .content(postRequestDTO.getContent())
                .postedAt(LocalDateTime.now())
                .build();
        return postRepository.save(entity);
    }

    public PostEntity view(PostViewRequest postViewRequest) {
        // 게시글이 있는가?
        return postRepository.findFirstByIdAndStatusOrderByIdDesc(postViewRequest.getPostId(),"REGISTERED")
                .map( it -> {
                    if(!it.getPassword().equals(postViewRequest.getPassword())) {
                        var format = "패스워드가 맞지 않습니다 기존 : %s vs 입력 : %s";
                        throw new RuntimeException(String.format(format,it.getPassword(), postViewRequest.getPassword()));
                    }

                    var replyList = replyService.findAllByPostId(it.getId());
                    it.setReplyList(replyList);

                    return it;
                }).orElseThrow(
                        () -> {
                            return new RuntimeException("해당 게시글이 존재하지 않습니다. : " + postViewRequest.getPostId());
                        }
                );
        // 비밀번호가 맞는가?
    }

    public List<PostEntity> all() {
        return postRepository.findAll();
    }

    public void delete(PostViewRequest postViewRequest) {
         postRepository.findById(postViewRequest.getPostId())
                .map( it -> {
                    if(!it.getPassword().equals(postViewRequest.getPassword())) {
                        var format = "패스워드가 맞지 않습니다. 기존 :  %s vs  입력 : %s";
                        throw new RuntimeException(String.format(format,it.getPassword(), postViewRequest.getPassword()));
                    }
                    it.setStatus("UNREGISTERED");
                    postRepository.save(it);
                    return it;
                }).orElseThrow(
                        () -> {
                            return new RuntimeException("해당 게시글이 존재하지 않습니다. : " + postViewRequest.getPostId());
                        }
                );
    }

}
