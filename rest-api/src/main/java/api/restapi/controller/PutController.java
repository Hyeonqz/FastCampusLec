package api.restapi.controller;

import api.restapi.dto.UserRequestDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/api")
@RestController
public class PutController {

    @PutMapping("/put")
    public void put(@RequestBody UserRequestDTO userRequestDTO) {
        log.info("request : {}",userRequestDTO);
    }
}
