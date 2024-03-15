package board.simpleboard.reply.service;

import board.simpleboard.crud.Converter;
import board.simpleboard.post.repository.PostRepository;
import board.simpleboard.reply.db.ReplyEntity;
import board.simpleboard.reply.model.ReplyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class ReplyConverter implements Converter<ReplyDto, ReplyEntity> {

    private final PostRepository postRepository;
    @Override
    public ReplyDto toDto(ReplyEntity replyEntity) {

        ReplyDto.builder()
                .id(replyEntity.getId())
                .postId(replyEntity.getPost().getId())
                .status(replyEntity.getStatus())
                .content(replyEntity.getContent())
                .title(replyEntity.getTitle())
                .userName(replyEntity.getUserName())
                .password(replyEntity.getPassword())
                .repliedAt(replyEntity.getRepliedAt())
                .build();


        return null;
    }

    @Override
    public ReplyEntity toEntity(ReplyDto replyDto) {

        var postEntity = postRepository.findById(replyDto.getId());

        ReplyEntity.builder()
                .id(replyDto.getId()) // 여기가 null 이면 insert, null 이 아니면 update 를 시킨다.
                .post(postEntity.get())
                .status( (replyDto.getStatus() != null) ? replyDto.getStatus() : "REGISTERED")
                .content(replyDto.getContent())
                .title(replyDto.getTitle())
                .userName(replyDto.getUserName())
                .password(replyDto.getPassword())
                .repliedAt( (replyDto.getRepliedAt() != null) ? replyDto.getRepliedAt() : LocalDateTime.now() )
                .build();
        return null;
    }
}
