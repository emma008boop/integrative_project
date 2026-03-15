package com.myapp.gestor.dto.User;

import jakarta.validation.constraints.Email;

public record UserUpdateAccountResponse(@Email
                                        String email,
                                        String message) {
}
