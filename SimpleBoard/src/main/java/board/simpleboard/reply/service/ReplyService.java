package board.simpleboard.reply.service;

import board.simpleboard.post.db.PostEntity;
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

    public ReplyEntity create(
            ReplyRequest request
    ) {
        var entity = ReplyEntity.builder()
                .postId(request.getPostId())
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
