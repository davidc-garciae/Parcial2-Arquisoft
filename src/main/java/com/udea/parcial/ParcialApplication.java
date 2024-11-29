package com.udea.parcial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class ParcialApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParcialApplication.class, args);
    }
}