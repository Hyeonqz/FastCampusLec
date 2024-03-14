package board.simpleboard.bboard.controller;

import board.simpleboard.bboard.db.BoardEntity;
import board.simpleboard.bboard.model.BoardRequestDTO;
import board.simpleboard.bboard.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/board")
@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;

    @PostMapping("")
    public BoardEntity create(
            @Valid
            @RequestBody BoardRequestDTO boardRequestDTO
            ) {
        return boardService.create(boardRequestDTO);
    }



}
