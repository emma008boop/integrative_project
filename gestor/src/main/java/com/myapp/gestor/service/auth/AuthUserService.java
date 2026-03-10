package com.myapp.gestor.service.auth;

import com.myapp.gestor.dto.auth.LoginUserRequest;
import com.myapp.gestor.dto.auth.LoginUserResponse;
import com.myapp.gestor.dto.auth.RegisterUserRequest;
import com.myapp.gestor.dto.auth.RegisterUserResponse;
import com.myapp.gestor.exception.EmailNotFoundException;
import com.myapp.gestor.model.User;
import com.myapp.gestor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthUserService implements AuthUserServiceInterface {

    @Autowired
    private UserRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public RegisterUserResponse register (RegisterUserRequest dto){
        if (repository.existByEmail(dto.email())){
            throw new EmailNotFoundException("You can't use the email:" + dto.email() + "cause already exists");
        }
        User user = new User();
        user.setEmail(dto.email());
        String passwordHashed = passwordEncoder.encode(dto.passwordHash());
        user.setPasswordHash(passwordHashed);

        return new RegisterUserResponse(dto.email());
    }

    public LoginUserResponse login (LoginUserRequest dto){
        User user = new User();

        if (repository.existByEmail(dto.email())){
            throw new EmailNotFoundException("Your email hasn't been found in database, please confirm your email");
        }
//        boolean isPasswordCorrect = passwordEncoder.matches(dto.password(), user.getPasswordHash());
//        if (!isPasswordCorrect){
//            throw new RuntimeException("Password does not match");
//        }
        return new LoginUserResponse("The login has been successfully done");
    }
}
