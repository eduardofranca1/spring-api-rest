package com.avaliacaobackend.domain.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(new Info()
                    .title("RESTful API With Spring Boot")
                    .version("v1")
                    .description("Api builded for a backend test")
                    .termsOfService("http://swagger.io/terms/")
                    .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}
