package com.udemy.api.services;

import com.udemy.api.domain.User;
import com.udemy.api.domain.dto.UserDto;

import java.util.List;

public interface UserService {

    User findById(Integer id);
    List<User> findAll();
    User create(UserDto obj);
    User update(UserDto obj);
}
