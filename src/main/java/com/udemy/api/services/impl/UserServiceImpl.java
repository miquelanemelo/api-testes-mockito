package com.udemy.api.services.impl;

import com.udemy.api.domain.User;
import com.udemy.api.repositories.UserRepository;
import com.udemy.api.services.UserService;
import com.udemy.api.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User findById(Integer id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow((()->new ObjectNotFoundException("Objeto não encontrado")));
    }
    public List<User> findAll(){
        return repository.findAll();
    }

}
