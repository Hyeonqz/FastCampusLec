package api.restapi.controller;

import api.restapi.dto.BookQueryParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.Month;

@Slf4j
@RequestMapping("/api")
@RestController
public class RestApiController {

    @GetMapping( "/hello")
    public String hello() {
        // 결국 서버로 전송되는 것은 문자이다.
        var html = "<html><body><h1>Hello Springboot </h1></body></html>";
        return html;
    }

    @GetMapping( "/echo/{message}/age/{age}/is-man/{isMan}")
    public String echo(
            @PathVariable("message") String message,
            @PathVariable("age") int age,
            @PathVariable("isMan") boolean isMan) {
        // PathVariable 에 null이 들어올 수 없다. 그러므로, null이 없는 원시 타입을 사용하는게 좋다

        System.out.println("message = " + message);
        System.out.println("age = " + age);
        System.out.println("isMan = " + isMan);

        return message.toUpperCase();
    }

    //쿼리파라미터 Ex1
    @GetMapping("/book")
    public void queryParam(
            @RequestParam String category,
            @RequestParam String issuedYear,
            @RequestParam(name="issued-month") String issuedMonth,
            @RequestParam(name="issued_day") String issuedDay) {

        log.info(category);
        log.info(issuedYear);
        log.info(issuedMonth);
        log.info(issuedDay);

    }

    //쿼리파라미터 EX2
    //한번에 객체를 받을 때는, dto랑 파라미터 name을 똑같이 해서 맵핑을 해야한다.
    @GetMapping("/book1")
    public void queryParam1 (BookQueryParam bookQueryParam) {
        log.info(String.valueOf(bookQueryParam));
    }
}
