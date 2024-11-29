package com.udea.parcial.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.udea.parcial.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(new springfox.documentation.service.ApiInfo(
                        "API de Pedidos",
                        "Documentación de la API de Pedidos",
                        "1.0",
                        "Terms of service",
                        new springfox.documentation.service.Contact("Nombre", "URL", "email"),
                        "License of API",
                        "API license URL",
                        java.util.Collections.emptyList()
                ));
    }
}