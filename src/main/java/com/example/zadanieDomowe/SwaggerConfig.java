package com.example.zadanieDomowe;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;

public class SwaggerConfig {
    @Bean
    public OpenAPI apiDocConfig() {
        return new OpenAPI()
                .info(new Info()
                        .title("Currency rest api")
                        .description("API DOCUMENTATION")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Paulina")
                                .email("s25067@pjwstk.edu.pl")));
    }
}