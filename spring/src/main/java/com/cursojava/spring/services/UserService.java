package com.cursojava.spring.services;

import com.cursojava.spring.entities.User;
import com.cursojava.spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository; //Precisamos dessa injeção para que possamos manipular dados da base de dados

    public List<User> findAll() { //Função para retornar todos os usuários.
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.get();
    }
}
