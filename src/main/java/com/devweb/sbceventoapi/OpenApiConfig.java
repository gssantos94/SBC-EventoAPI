package com.devweb.sbceventoapi;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("SBC Evento API REST")
                        .version("v1")
                        .description("API desenvolvida para a disciplina de Desenvolvimento Web - UFF 2023.2")
                );
    }
}