package com.financialctl.financialinfo.controllers;

import com.financialctl.financialinfo.domain.services.UserService;
import com.financialctl.financialinfo.dtos.UserPostDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody final UserPostDto userPostDto) {
        userService.createUser(userPostDto);
        return ResponseEntity.ok("User created");
    }
}
