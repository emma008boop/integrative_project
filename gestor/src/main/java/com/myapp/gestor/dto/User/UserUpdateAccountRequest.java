package com.myapp.gestor.dto.User;

import jakarta.validation.constraints.Email;

public record UserUpdateAccountRequest(@Email
                                       String email,
                                       String password) {
}
