package com.myapp.gestor.service.auth;

import com.myapp.gestor.dto.auth.RegisterUserRequest;
import com.myapp.gestor.dto.auth.RegisterUserResponse;
import com.myapp.gestor.exception.EmailNotFoundException;
import com.myapp.gestor.model.User;
import com.myapp.gestor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthUserService extends AuthUserServiceInterface {

    @Autowired
    private UserRepository repository;

    public RegisterUserResponse register (RegisterUserRequest dto){
        if (repository.existByEmail(dto.email())){
            throw new EmailNotFoundException("You can't use the email:" + dto.email() + "cause already exists");
        }
        User user = new User();
        user.setEmail(dto.email());

    }

}
