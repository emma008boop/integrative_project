package com.myapp.gestor.service.auth;

import com.myapp.gestor.dto.auth.LoginUserRequest;
import com.myapp.gestor.dto.auth.LoginUserResponse;
import com.myapp.gestor.dto.auth.RegisterUserRequest;
import com.myapp.gestor.dto.auth.RegisterUserResponse;

public interface AuthUserServiceInterface {
    RegisterUserResponse register(RegisterUserRequest dto);
    LoginUserResponse login (LoginUserRequest dto);
}
