package com.udemy.api.services.impl;

import com.udemy.api.domain.User;
import com.udemy.api.domain.dto.UserDto;
import com.udemy.api.repositories.UserRepository;
import com.udemy.api.services.UserService;
import com.udemy.api.services.exceptions.DataIntegratyViolationException;
import com.udemy.api.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public User findById(Integer id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow((()->new ObjectNotFoundException("Objeto não encontrado")));
    }
    public List<User> findAll(){
        return repository.findAll();
    }

    @Override
    public User create(UserDto obj) {
        findByEmail(obj);
        return repository.save(mapper.map(obj, User.class));
    }

    private void findByEmail(UserDto obj){
        Optional<User> user = repository.findByEmail(obj.getEmail());
        if(user.isPresent()){
            throw new DataIntegratyViolationException("E-mail já cadastrado");
        }
    }

}
