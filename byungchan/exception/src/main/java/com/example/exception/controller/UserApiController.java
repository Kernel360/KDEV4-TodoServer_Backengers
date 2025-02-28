package com.example.exception.controller;

import com.example.exception.model.Api;
import com.example.exception.model.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserApiController {
    private static List<UserResponse> userList = List.of(
            createUserResponse("1", "홍길동", 10),
            createUserResponse("2", "김철수", 20),
            createUserResponse("3", "고길동", 30),
            createUserResponse("4", "아길동", 40),
            createUserResponse("5", "고철수", 50)
    );
    private final RestClient.Builder builder;

    public UserApiController(RestClient.Builder builder) {
        this.builder = builder;
    }

    @GetMapping("/id/{userId}")
    public Api<UserResponse> getUser(
            @PathVariable String userId
    ) {
        UserResponse user = userList.stream()
                .filter(
                        it -> it.getId().equals(userId)
                )
                .findFirst()
                .get();

        Api<UserResponse> response = Api.<UserResponse>builder()
                .resultCode(String.valueOf(HttpStatus.OK.value()))
                .resultMessage(HttpStatus.OK.name())
                .data(user)
                .build();

        return response;
    }

    private static UserResponse createUserResponse(String id, String name, Integer age) {
        return new UserResponse(id, name, age);
    }
}
