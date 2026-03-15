package com.myapp.gestor.dto.User;

import jakarta.validation.constraints.Email;

public record UserDeleteAccountRequest(@Email
                                       String email,
                                       String password) {
}
