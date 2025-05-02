package com.cursojava.spring.config;

import com.cursojava.spring.entities.Category;
import com.cursojava.spring.entities.User;
import com.cursojava.spring.entities.Order;
import com.cursojava.spring.entities.enums.OrderStatus;
import com.cursojava.spring.repositories.CategoryRepository;
import com.cursojava.spring.repositories.OrderRepository;
import com.cursojava.spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner { //Essa classe é responsável por fazer testes de perfil


    @Autowired //Usamos o Autowired para associar uma instância de UserRepository aqui dentro
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
    //Tudo o que eu colocar aqui dentro desse método, será executado ao inciar a aplicação.
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1, OrderStatus.PAID);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2, OrderStatus.WAITING_PAYMENT);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1, OrderStatus.PAID);

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
    }


}
