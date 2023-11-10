package com.ms.auth.controllers;

import com.ms.auth.domain.user.AuthenticationDTO;
import com.ms.auth.domain.user.LoginResponseDTO;
import com.ms.auth.domain.user.RegisterDTO;
import com.ms.auth.domain.user.TokenDTO;
import com.ms.auth.domain.user.User;
import com.ms.auth.services.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    private final UserService userService;

    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AuthenticationDTO data){
        return userService.login(data);
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody @Valid RegisterDTO data){
        return userService.register(data);
    }

    @GetMapping("/token/{token}")
    public ResponseEntity<LoginResponseDTO> validateToken(@PathVariable("token") String token){
        return userService.validateToken(token);
    }
}
