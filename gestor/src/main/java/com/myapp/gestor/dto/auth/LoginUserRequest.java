package com.myapp.gestor.dto.auth;

import jakarta.validation.constraints.Email;
import lombok.Builder;

@Builder
public record LoginUserRequest(@Email (message = "It isn't in email format")
                               String email,
                               String password) {
}
