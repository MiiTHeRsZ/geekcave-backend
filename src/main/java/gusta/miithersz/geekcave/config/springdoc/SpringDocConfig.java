package gusta.miithersz.geekcave.config.springdoc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer")
                                        .bearerFormat("JWT")))
                .info(new Info()
                        .title("Geek Cave API")
                        .description("API from Geek Cave application")
                        .contact(new Contact()
                                .name("Gustavo Leme")
                                .url("https://www.linkedin.com/in/gustavomiithleme/")
                                .email("gustavo_leme05@hotmail.com"))
                        .version("v0.1"));
    }

}
