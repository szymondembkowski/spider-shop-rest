package com.spidershop.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Spider Shop API")
                        .version("1.0")
                        .description("REST API to manage spiders, users and orders.")
                        .contact(new Contact()
                                .name("Github")
                                .url("https://github.com/szymondembkowski")
                        )
                );
    }
}
