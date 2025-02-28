package com.example.rest_api.controller;

import com.example.rest_api.model.CreateUserRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ResponseApiController {

    @GetMapping("")
    public ResponseEntity<CreateUserRequest> user() {
        var user = new CreateUserRequest();
        user.setUserName("홍길동");
        user.setUserAge(20);
        user.setEmail("korean@gmail.com");

        var response = ResponseEntity
                .status(HttpStatus.OK)
                .header("x-custom","hi")
                .body(user);

        return response;
    }
}
