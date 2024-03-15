package board.simpleboard.reply.controller;

import board.simpleboard.common.Api;
import board.simpleboard.crud.CrudApiAbstractController;
import board.simpleboard.reply.db.ReplyEntity;
import board.simpleboard.reply.model.ReplyDto;
import board.simpleboard.reply.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/reply")
@RequiredArgsConstructor
@RestController
public class ReplyApiController extends CrudApiAbstractController<ReplyDto, ReplyEntity> {
    private final ReplyService replyService;

  /*  @PostMapping("")
    public ReplyEntity create(
            @Valid
            @RequestBody ReplyRequest request
            ) {
        return replyService.create(request);

    }*/

    @Override
    public ReplyDto create(ReplyDto replyDto) {
        return super.create(replyDto);
    }

    @Override
    public Optional<ReplyDto> read(Long id) {
        return super.read(id);
    }

    @Override
    public ReplyDto update(ReplyDto replyDto) {
        return super.update(replyDto);
    }

    @Override
    public void delete(Long id) {
        super.delete(id);
    }

    @Override
    public Api<List<ReplyDto>> list(Pageable pageable) {
        return super.list(pageable);
    }
}
