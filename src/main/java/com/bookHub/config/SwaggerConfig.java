package com.bookHub.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI bookHubOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Book API")
                        .description("REST API for managing books in BookHub project")
                        .version("1.0.0")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}
