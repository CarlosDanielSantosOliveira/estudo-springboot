package com.cursojava.spring.config;

import com.cursojava.spring.entities.User;
import com.cursojava.spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner { //Essa classe é responsável por fazer testes de perfil


    @Autowired //Usamos o Autowired para associar uma instância de UserRepository aqui dentro
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
    //Tudo o que eu colocar aqui dentro desse método, será executado ao inciar a aplicação.
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
