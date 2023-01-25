package com.udemy.api.config;

import com.udemy.api.domain.User;
import com.udemy.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepository repository;

    @Bean
    public void startDB(){
        User user1 = new User(null, "Miquelane", "miquelane@gmail", "123");
        User user2 = new User(null, "Bebel", "bebel@gmail", "123");
        repository.saveAll(List.of(user1, user2));
    }


}
