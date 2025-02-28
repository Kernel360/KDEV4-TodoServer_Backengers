package com.example.rest_api.controller;

import com.example.rest_api.model.BookRequest;
import com.example.rest_api.model.CreateUserRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostApiController {

    @PostMapping("/post")
    public String post(
            @RequestBody BookRequest req
    ) {
        System.out.println(req);
        return req.toString();
    }

    @PostMapping("/post/user")
    public CreateUserRequest createUser(@RequestBody CreateUserRequest req) {
        System.out.println(req.toString());
        return req;
    }
}
