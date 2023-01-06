package com.example.project_toy.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public GroupedOpenApi conversationApi() {
        return GroupedOpenApi.builder()
                .group("Toy")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Toy API")
                        .description("Toy for improve skills")
                        .version("v0.0.1"));
    }
}
