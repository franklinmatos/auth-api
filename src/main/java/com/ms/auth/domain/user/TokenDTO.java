package com.ms.auth.domain.user;

import jakarta.validation.constraints.NotBlank;

public record TokenDTO(@NotBlank String token) {
}
