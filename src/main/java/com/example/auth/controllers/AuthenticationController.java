package com.example.auth.controllers;

import com.example.auth.domain.user.AuthenticationDTO;
import com.example.auth.domain.user.LoginResponseDTO;
import com.example.auth.domain.user.RegisterDTO;
import com.example.auth.domain.user.User;
import com.example.auth.infra.security.TokenService;
import com.example.auth.repositories.UserRepository;
import com.example.auth.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
