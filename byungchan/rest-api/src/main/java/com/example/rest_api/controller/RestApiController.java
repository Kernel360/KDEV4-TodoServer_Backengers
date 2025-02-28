package com.example.rest_api.controller;

import com.example.rest_api.model.BookQueryParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api") // /api 라는 주소로 요청을 받겠다는 의미
public class RestApiController {

    @GetMapping(path = "/hello")
    public String hello() {
        // 응답의 데이터 형식은 문자열
        var html = "<html> <body> <h1>Hello Spring Boot</h1> </body> </html>";
        return html;
    }

    @GetMapping(path = "/echo/{message}/age/{age}/is-man/{isMan}")
    public String echo(
            @PathVariable(name = "message") String msg,
            @PathVariable int age,
            @PathVariable boolean isMan
    ) {
        System.out.println("echo message: " + msg);
        System.out.println("echo age: " + age);
        System.out.println("echo isMan: " + isMan);
        return msg.toUpperCase();
    }

    @GetMapping("/book")
    public void queryParams(
            @RequestParam String category,
            @RequestParam String issuedYear,
            @RequestParam(name = "issued-month") String issuedMonth,
            @RequestParam(name = "issued_day") String issuedDay
    ) {
        System.out.println(category);
        System.out.println(issuedYear);
        System.out.println(issuedMonth);
        System.out.println(issuedDay);
    }

    @GetMapping("/book2")
    public void queryParamDto(
            BookQueryParam bookQueryParam
    ) {
        System.out.println(bookQueryParam.getCategory());
        System.out.println(bookQueryParam.getIssuedYear());
        System.out.println(bookQueryParam.getIssuedMonth());
        System.out.println(bookQueryParam.getIssuedDay());
    }

    @GetMapping("/calc")
    public void calc(
            @RequestParam int a,
            @RequestParam int b
    ) {
        System.out.println(a + b);
        System.out.println(a * b);
    }

    @GetMapping("/person")
    public void bool(
            @RequestParam(name = "is-man") boolean isMan
    ) {
        System.out.println(isMan);
    }

    @DeleteMapping(path = {
            "/user/{userName}/delete",
            "/user/{userName}/del"
    })
    public void delete(
            @PathVariable String userName
    ) {
        log.info("user-name: {}", userName);
    }
}
