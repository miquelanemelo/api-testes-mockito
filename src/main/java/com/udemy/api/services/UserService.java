package com.udemy.api.services;

import com.udemy.api.domain.User;

public interface UserService {

    User findById(Integer id);
}
