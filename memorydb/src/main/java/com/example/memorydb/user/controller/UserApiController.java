package com.example.memorydb.user.controller;

import com.example.memorydb.user.model.UserEntity;
import com.example.memorydb.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserApiController {

    private final UserService userService;


    @PutMapping("")
    public UserEntity create(
            @RequestBody UserEntity userEntity
    ) {
        return userService.save(userEntity);
    }

    @GetMapping("/all")
    public List<UserEntity> findAll() {
        return userService.findAll();
    }

    @GetMapping("/id/{id}")
    public UserEntity findById(
            @PathVariable Long id
    ) {
        return userService.findById(id).get();
    }

    @DeleteMapping("/id/{id}")
    public void delete(
            @PathVariable Long id
    ) {
        userService.delete(id);
    }

    @GetMapping("/score")
    public List<UserEntity> filterScore(
            @RequestParam int score
    ) {
        return userService.filterScore(score);
    }
}
