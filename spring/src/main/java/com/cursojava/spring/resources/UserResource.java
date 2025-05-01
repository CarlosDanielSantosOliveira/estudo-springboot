package com.cursojava.spring.resources;

import com.cursojava.spring.entities.User;
import com.cursojava.spring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users") //Disponibilizando o recurso /users para consumo.
public class UserResource {

    @Autowired
    private UserService service; //Injeção de dependência para acessarmos as funções da service de User
    @GetMapping
    public ResponseEntity<List<User>> findAll() {

        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list); //Estamos dizendo que se a resposta da chamada estiver ok, vamos retornar o body, ou seja, os dados.
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) { //PathVariable serve para que o Spring aceite esse parâmetro como um valor a ser consumido, após o usuário passar na chamada

        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
