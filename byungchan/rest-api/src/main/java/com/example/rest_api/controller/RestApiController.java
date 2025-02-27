package com.example.rest_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api") // /api 라는 주소로 요청을 받겠다는 의미
public class RestApiController {

    @GetMapping(path = "/hello")
    public String hello() {
        // 응답의 데이터 형식은 문자열
        var html = "<html> <body> <h1>Hello Spring Boot</h1> </body> </html>";
        return html;
    }
}
