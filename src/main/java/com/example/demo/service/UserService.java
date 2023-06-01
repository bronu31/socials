package com.example.demo.service;

import com.example.demo.model.Users;

public interface UserService {

    Users saveUser(Users users);

    Users getUserById(Long id);
}
