package database.dgad;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class das {

    @GetMapping("/go")
    public String go() {
        return "hi";
    }
}
