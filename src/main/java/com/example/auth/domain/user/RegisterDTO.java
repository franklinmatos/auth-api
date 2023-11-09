package com.example.auth.domain.user;

import jakarta.validation.constraints.Email;

public record RegisterDTO(String login, String password, UserRole role, @Email String email) {
}
