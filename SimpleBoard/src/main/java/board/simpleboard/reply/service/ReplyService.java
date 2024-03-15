package board.simpleboard.reply.service;

import board.simpleboard.post.db.PostEntity;
import board.simpleboard.post.repository.PostRepository;
import board.simpleboard.reply.db.ReplyEntity;
import board.simpleboard.reply.model.ReplyRequest;
import board.simpleboard.reply.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ReplyService {
    private final ReplyRepository repository;
    private final PostRepository postRepository;

    public ReplyEntity create(
            ReplyRequest request
    ) {
        var postEntity  = postRepository.findById(request.getPostId());

        if (postEntity.isEmpty()) {
            throw new RuntimeException("게시물이 존재하지 않습니다 : " + request.getPostId());
        }

        var entity = ReplyEntity.builder()
                .post(postEntity.get())
                .userName(request.getUserName())
                .password(request.getPassword())
                .status("REGISTERED")
                .title(request.getTitle())
                .content(request.getContent())
                .repliedAt(LocalDateTime.now())
                .build();

        return repository.save(entity);
    }

    public List<ReplyEntity> findAllByPostId(Long PostId) {
        return repository.findAllByPostIdAndStatusOrderByIdDesc(PostId,"REGISTERED");
    }
}
