package com.cursojava.spring.resources;

import com.cursojava.spring.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users") //Disponibilizando o recurso /users para consumo.
public class UserResource {
    @GetMapping
    public ResponseEntity<User> findAll() {
        User u = new User(1L, "Daniel", "daniel@gmail.com", "123456", "1234");
        return ResponseEntity.ok().body(u); //Estamos dizendo que se a resposta da chamada estiver ok, vamos retornar o body, ou seja, os dados.
    }
}
