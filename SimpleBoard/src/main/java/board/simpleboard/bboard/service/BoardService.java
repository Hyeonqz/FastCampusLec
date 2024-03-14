package board.simpleboard.bboard.service;

import board.simpleboard.bboard.db.BoardEntity;
import board.simpleboard.bboard.model.BoardRequestDTO;
import board.simpleboard.bboard.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardEntity create(BoardRequestDTO boardRequestDTO) {

        var entity = BoardEntity.builder()
                .boardName(boardRequestDTO.getBoardName())
                .status("REGISTERED")
                .build();

        return boardRepository.save(entity);

    }
}
