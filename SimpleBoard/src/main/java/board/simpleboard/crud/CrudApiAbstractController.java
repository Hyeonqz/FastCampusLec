package board.simpleboard.crud;

import board.simpleboard.common.Api;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public abstract class CrudApiAbstractController<DTO, ENTITY> implements CRUDInterface<DTO> {

    @Autowired
    private CRUDAbstractService<DTO,ENTITY> crudAbstractService;

    @PostMapping
    @Override
    public DTO create(@Valid @RequestBody DTO dto) {
        return crudAbstractService.create(dto);
    }

    @GetMapping("/id/{id}")
    @Override
    public Optional<DTO> read(@PathVariable Long id) {
        return crudAbstractService.read(id);
    }

    @PostMapping()
    @Override
    public DTO update(@Valid @RequestBody DTO dto) {
        return crudAbstractService.update(dto);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public void delete(@PathVariable Long id) {
        crudAbstractService.delete(id);
    }

    @GetMapping("/all")
    @Override
    public Api<List<DTO>> list(@PageableDefault Pageable pageable) {
        return crudAbstractService.list(pageable);
    }
}
