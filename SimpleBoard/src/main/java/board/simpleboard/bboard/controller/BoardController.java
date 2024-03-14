package board.simpleboard.bboard.controller;

import board.simpleboard.bboard.db.BoardEntity;
import board.simpleboard.bboard.model.BoardDto;
import board.simpleboard.bboard.model.BoardRequestDTO;
import board.simpleboard.bboard.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/board")
@Slf4j
@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;

    @PostMapping("")
    public BoardDto create(
            @Valid
            @RequestBody BoardRequestDTO boardRequestDTO
            ) {
        return boardService.create(boardRequestDTO);
    }

    @GetMapping("/id/{id}")
    public BoardDto view (@PathVariable Long id) {
        var entity = boardService.view(id);

        log.info("result : {}", entity);
        return entity;
    }



}
