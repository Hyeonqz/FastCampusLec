package board.simpleboard.bboard.service;

import board.simpleboard.bboard.db.BoardEntity;
import board.simpleboard.bboard.model.BoardDto;
import board.simpleboard.bboard.model.BoardRequestDTO;
import board.simpleboard.bboard.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final BoardConverter boardConverter;

    public BoardDto create(BoardRequestDTO boardRequestDTO) {

        var entity = BoardEntity.builder()
                .boardName(boardRequestDTO.getBoardName())
                .status("REGISTERED")
                .build();

        var saveEntity = boardRepository.save(entity);

        return boardConverter.toDto(saveEntity);

    }

    public BoardDto view(Long id) {
        var entity = boardRepository.findById(id);

         return boardConverter.toDto(entity.get());
    }
}
