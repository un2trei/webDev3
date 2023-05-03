package com.complete.blog.service;

import com.complete.blog.dto.RegistrationDto;
import com.complete.blog.entity.User;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);

    User findByEmail(String email);
}
