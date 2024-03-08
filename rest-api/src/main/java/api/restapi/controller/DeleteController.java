package api.restapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/api")
@RestController
public class DeleteController {

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        log.info("id : {}" , id);
    }
}
