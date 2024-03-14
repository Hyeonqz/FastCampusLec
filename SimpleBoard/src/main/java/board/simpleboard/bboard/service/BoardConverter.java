package board.simpleboard.bboard.service;

import board.simpleboard.bboard.db.BoardEntity;
import board.simpleboard.bboard.model.BoardDto;
import board.simpleboard.post.service.PostConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardConverter {

    private final PostConverter postConverter;

    // 데이터를 변환해준다.

    // BoardEntity 가 들어오면 BoardDto 로 변환을 해준다.
    public BoardDto toDto(BoardEntity boardEntity) {

        var postList = boardEntity.getPostList()
                .stream()
                .map(postConverter::toDto)
                .collect(Collectors.toList());

        return BoardDto.builder()
                .id(boardEntity.getId())
                .boardName(boardEntity.getBoardName())
                .status(boardEntity.getStatus())
                .postList(boardEntity.getPostList())
                .build();
    }
}
