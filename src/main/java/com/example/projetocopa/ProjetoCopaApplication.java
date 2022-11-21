package com.example.projetocopa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ProjetoCopaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetoCopaApplication.class, args);
        System.out.println(new BCryptPasswordEncoder().encode("1234"));
    }

}