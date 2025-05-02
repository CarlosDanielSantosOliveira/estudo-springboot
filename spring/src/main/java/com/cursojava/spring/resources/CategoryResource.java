package com.cursojava.spring.resources;

import com.cursojava.spring.entities.Category;
import com.cursojava.spring.entities.Order;
import com.cursojava.spring.services.CategoryService;
import com.cursojava.spring.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories") //Disponibilizando o recurso /users para consumo.
public class CategoryResource {

    @Autowired
    private CategoryService service; //Injeção de dependência para acessarmos as funções da service de User
    @GetMapping
    public ResponseEntity<List<Category>> findAll() {

        List<Category> list = service.findAll();
        return ResponseEntity.ok().body(list); //Estamos dizendo que se a resposta da chamada estiver ok, vamos retornar o body, ou seja, os dados.
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) { //PathVariable serve para que o Spring aceite esse parâmetro como um valor a ser consumido, após o usuário passar na chamada

        Category obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
